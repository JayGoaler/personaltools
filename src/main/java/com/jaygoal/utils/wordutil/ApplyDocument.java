package com.jaygoal.utils.wordutil;

import com.google.common.collect.Maps;
import com.jaygoal.pojo.ReportInputDto;
import com.jaygoal.utils.IDGenerateUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * <h3>申請扣押品 文书</h3>
 * <p>
 * 2018/3/12
 *
 * @author jaygoaler
 * @since 1.8
 */
@Component
public class ApplyDocument{
    @javax.annotation.Resource
    private ResourceLoader resourceLoader;

    private Configuration conf = null;
    private String srcPath;
    private final DocumentBuilder docBuilder = new DocumentBuilder();

    @Value("${word.targetPath}")
    private String targetPath;

    public String createReport(ReportInputDto inputDto) throws IllegalAccessException, IOException, TemplateException {
        if(conf==null){
            srcPath = getResourcePath();
            Path path = Paths.get(srcPath);
            conf = getConf(path);
        }
        //填充数据
        Map<String, Object> map = objectToMap(inputDto);

        //
        String unique = unique();

        //用数据替换模版
        File ooXml = new File(targetPath + unique + "_document.xml");

        String ftl = "document.ftl";
        Template template = conf.getTemplate(ftl);


        FileOutputStream fos = new FileOutputStream(ooXml);

        Writer out = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8), 10240);

        template.process(map, out);
        out.flush();
        out.close();


        String targetFileName = unique + "-(apply).docx";
        String targetFilePath = targetPath + File.separator + targetFileName;

        //用新的ooXml覆盖之前的ooXml
        String sourceDoc = "ReportTemp.docx";
        InputStream is = new FileInputStream(srcPath+File.separator+sourceDoc);
        docBuilder.coverOOXML(ooXml, is, targetFilePath);

        return targetFilePath;
    }


    private String getResourcePath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/reportTemp");
        return resource.getFile().getAbsolutePath();
    }

    private String unique () {
        return IDGenerateUtils.getId();
    }
    
    private Configuration getConf(Path path){
        Configuration result = new Configuration(Configuration.VERSION_2_3_30);
        result.setDefaultEncoding("utf-8");
        try {
            result.setDirectoryForTemplateLoading(path.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取对象的map数据
     * @param obj 传入的参数对象
     * @return 对象map
     * @throws IllegalAccessException exception
     */
    private  Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = Maps.newHashMap();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            map.put(fieldName, value);
        }
        return map;
    }
}
