package com.jaygoal.utils.wordutil;

import com.jaygoal.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * <h3></h3>
 * <p>
 * 2018/6/27
 *
 * @since 1.8
 */
public class DocumentBuilder {

    private final Logger LOG = LoggerFactory.getLogger(DocumentBuilder.class);

    private Charset UTF8 = Charset.forName("UTF-8");

    private static final String W_DOCUMENT = "word/document.xml";
    private static final String W_FOOTER2 = "word/footer2.xml";
    private static final String W_FOOTER1 = "word/footer1.xml";
    private static final String W_ENDNOTES = "word/endnotes.xml";
    private static final String W_FONTTABLE = "word/fontTable.xml";
    private static final String W_FONTNOTES = "word/fontnotes.xml";
    private static final String W_SETTINGS = "word/settings.xml";
    private static final String W_STYLES = "word/styles.xml";
    private static final String w_websettings = "word/webSettings.xml";

    /**
     * 替换 office open xml
     *
     * @param ooXml
     * @param sourceDoc 源文档
     * @param targetDoc 目标文档
     * @throws IOException
     */
    public void coverOOXML(File ooXml, String sourceDoc, String targetDoc) throws IOException {

        //zip输出流
        ZipOutputStream zos = getZipOutputStream(targetDoc);


        byte[] buffer = new byte[1024];

        ZipFile zipFile = new ZipFile(new File(sourceDoc), UTF8);
        Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
        while (zipEntries.hasMoreElements()) {
            ZipEntry next = zipEntries.nextElement();

            zos.putNextEntry(new ZipEntry(next.toString()));

            //替换掉
            if (W_DOCUMENT.equals(next.toString())) {
                InputStream in = new FileInputStream(ooXml);
                write(zos, buffer, in);
            } else {
                InputStream is = zipFile.getInputStream(next);
                write(zos, buffer, is);
            }

            LOG.info(" ---> " + zipFile.getName() + " 替换了 " + next.toString());
        }

        zos.close();

        FileUtils.delete(ooXml);
    }

    /**
     * 替换 office open xml
     *
     * @param ooXml
     * @param sourceDoc 源文档
     * @param targetDoc 目标文档
     * @throws IOException
     */
    public void coverOOXML(File ooXml, InputStream sourceDoc, String targetDoc) throws IOException {

        //zip输出流
        ZipOutputStream zos = getZipOutputStream(targetDoc);

        byte[] buffer = new byte[1024];

        ZipInputStream zis = new ZipInputStream(sourceDoc, UTF8);
        ZipEntry next;
        while ((next = zis.getNextEntry()) != null) {

            zos.putNextEntry(new ZipEntry(next.toString()));

            //替换掉
            if (W_DOCUMENT.equals(next.toString())) {
                InputStream in = new FileInputStream(ooXml);
                write(zos, buffer, in);
            } else {
                byte[] data = getByte(zis); // 获取当前条目的字节数组
                InputStream is = new ByteArrayInputStream(data); // 把当前条目的字节数据转换成InputStream
                write(zos, buffer, is);
            }

            LOG.info(" ---> " + zis.toString() + " 替换了 " + next.toString());
        }
        zos.close();

        FileUtils.delete(ooXml);
    }

    public void coverOOXML2(File ooXml, File ooXml2, InputStream sourceDoc, String targetDoc) throws IOException {

        //zip输出流
        ZipOutputStream zos = getZipOutputStream(targetDoc);

        byte[] buffer = new byte[1024];

        ZipInputStream zis = new ZipInputStream(sourceDoc, UTF8);
        ZipEntry next;
        while ((next = zis.getNextEntry()) != null) {

            zos.putNextEntry(new ZipEntry(next.toString()));

            //替换掉
            if (W_DOCUMENT.equals(next.toString())) {
                InputStream in = new FileInputStream(ooXml);
                write(zos, buffer, in);
            } else if (W_FOOTER2.equals(next.toString())) {
                InputStream in = new FileInputStream(ooXml2);
                write(zos, buffer, in);
            } else {
                byte[] data = getByte(zis); // 获取当前条目的字节数组
                InputStream is = new ByteArrayInputStream(data); // 把当前条目的字节数据转换成InputStream
                write(zos, buffer, is);
            }

            LOG.info(" ---> " + zis.toString() + " 替换了 " + next.toString());
        }
        zos.close();

//        FileUtils.delete(ooXml);
    }

    public void coverOOXML1(File ooXml, File ooXml1, InputStream sourceDoc, String targetDoc) throws IOException {

        //zip输出流
        ZipOutputStream zos = getZipOutputStream(targetDoc);

        byte[] buffer = new byte[1024];

        ZipInputStream zis = new ZipInputStream(sourceDoc, UTF8);
        ZipEntry next;
        while ((next = zis.getNextEntry()) != null) {

            zos.putNextEntry(new ZipEntry(next.toString()));

            //替换掉
            if (W_DOCUMENT.equals(next.toString())) {
                InputStream in = new FileInputStream(ooXml);
                write(zos, buffer, in);
            } else if (W_FOOTER1.equals(next.toString())) {
                InputStream in = new FileInputStream(ooXml1);
                write(zos, buffer, in);
            } else {
                byte[] data = getByte(zis); // 获取当前条目的字节数组
                InputStream is = new ByteArrayInputStream(data); // 把当前条目的字节数据转换成InputStream
                write(zos, buffer, is);
            }

            LOG.info(" ---> " + zis.toString() + " 替换了 " + next.toString());
        }
        zos.close();

//        FileUtils.delete(ooXml);
    }

    private ZipOutputStream getZipOutputStream(String targetDoc) throws FileNotFoundException {
        //zip输出流
        return new ZipOutputStream(new FileOutputStream(targetDoc), UTF8);
    }


    /**
     * 写入zip流
     *
     * @param zos    zos
     * @param buffer buffer
     * @param in     输入流
     * @throws IOException IO异常
     */
    private void write(ZipOutputStream zos, byte[] buffer, InputStream in) throws IOException {

        int len;
        while ((len = in.read(buffer)) != -1) {
            zos.write(buffer, 0, len);
        }

        in.close();
    }

    /**
     * 获取条目byte[]
     *
     * @param zis
     * @return
     */
    private byte[] getByte(InflaterInputStream zis) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] temp = new byte[1024];
        byte[] buf;
        int length;

        while ((length = zis.read(temp, 0, 1024)) != -1) {
            bout.write(temp, 0, length);
        }

        buf = bout.toByteArray();
        bout.close();
        return buf;
    }

}
