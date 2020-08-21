package com.jaygoal.utils;

import com.google.common.collect.Lists;
import com.jaygoal.pojo.Brief;
import com.jaygoal.pojo.Case;
import com.jaygoal.pojo.City;
import com.jaygoal.pojo.ReportInputDto;
import com.jaygoal.utils.wordutil.ApplyDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsTest {
    @Resource
    private ApplyDocument applyDocument;

    @Value("${word.targetPath}")
    private String targetPath;

    @Test
    public void test() throws Exception {
        System.out.println(1==1);
        String path = applyDocument.createReport(getInputDto());
    }


    private static ReportInputDto getInputDto() {
        ReportInputDto inputDto =  new ReportInputDto("武汉",20,7,20,8,10,12.5,10,20.0,5.0,1.2,0.2,null,null,0,120,20,30.0,100,40.0,
                90,10,10.0,1.1,-0.1,"长得丑",10,682,996);
        List<Case> caseList = Lists.newArrayList(new Case("妨碍公务罪",10,10.2,0.5));
        List<City> cityList = Lists.newArrayList(new City("武汉",10,0.5),new City("黄冈",20,0.1));
        List<Brief> briefs = Lists.newArrayList(new Brief("案由1",10,5.5,5.6));
        inputDto.setCaseTypeList(caseList);
        inputDto.setWorkNumberList(cityList);
        inputDto.setBriefList(briefs);
        return inputDto;
    }
}