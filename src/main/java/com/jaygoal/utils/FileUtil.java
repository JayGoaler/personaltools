package com.jaygoal.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 *
 * @author JayGoal
 * @date 2019/11/13
 */
@Slf4j
public class FileUtil {

    /**
     * 创建文件
     * @param fileName(全路径)  文件名称
     * @param fileContent   文件内容
     * @return  是否创建成功，成功则返回true
     */
    public static boolean createFile(String fileName, String fileContent){
        Boolean bool = false;
        File file = new File(fileName);
        try {
            //如果文件不存在，则创建新的文件
            if(!file.exists()){
                file.createNewFile();
                bool = true;
                //创建文件成功后，写入内容到文件里
                writeFileContent(fileName, fileContent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bool;
    }

    /**
     * 创建文件
     * @param fileName(全路径)  文件名称
     * @param filecontent   文件内容
     * @return  是否创建成功，成功则返回true
     */
    public static boolean createFileAndWriteLines(String fileName, String[] filecontent){
        Boolean bool = false;
        File file = new File(fileName);
        try {
            //如果文件不存在，则创建新的文件
            if(!file.exists()){
                file.createNewFile();
                bool = true;
                //创建文件成功后，写入内容到文件里
                for(String item:filecontent){
                    writeFileContent(fileName, item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bool;
    }

    /**
     * 向文件中写入内容
     * @param filepath 文件路径与名称
     * @param newstr  写入的内容
     * @return
     * @throws IOException
     */
    public static boolean writeFileContent(String filepath, String newstr) throws IOException {
        Boolean bool = false;
        //新写入的行，换行
        String filein = newstr+"\r\n";
        String temp  = "";
        File file = new File(filepath);
        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr);
             FileOutputStream fos = new FileOutputStream(file);
             PrintWriter pw = new PrintWriter(fos);
        ){
            StringBuffer buffer = new StringBuffer();
            //文件原有内容
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        }
        return bool;
    }

    public static String readFileToString(String fileName){
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try (FileInputStream in = new FileInputStream(file)){

            int count = in.read(filecontent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    public static String readFileToString(File file) {
        String encoding = "UTF-8";
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try (FileInputStream in = new FileInputStream(file)){
            int count = in.read(filecontent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    public static String readFileToString(InputStream in){
        String encoding = "UTF-8";
        try {
            byte[] filecontent = new byte[in.available()];
            int count = in.read(filecontent);
            in.close();
            return new String(filecontent, encoding);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}