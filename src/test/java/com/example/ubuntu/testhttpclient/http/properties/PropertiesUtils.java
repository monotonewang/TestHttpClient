package com.example.ubuntu.testhttpclient.http.properties;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {

    static String filePath = "/java/";
    static String fileName = "weixue.properties";


    public static String getKeyValue(String key) {

        String filePath = getFilePath();
        // 如果文件夹不存在就创建
        File folder = new File(filePath);
        String absolutePath = folder.getAbsolutePath();
        System.out.println("absolutePath=" + absolutePath);
        if (!folder.exists() && !folder.isDirectory()) {
            System.out.println("//不存在");
            folder.mkdirs();
        }
        // 如果文件不存在就创建
        File file = new File(filePath + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Properties props = new Properties();
        try {
            // 读取文件
            FileInputStream fis = new FileInputStream(filePath + fileName);
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return props.getProperty(key);
    }

    public static String getFilePath() {
        if(filePath.equals("/java/")){
            String name = PropertiesUtils.class.getPackage().getName() + "/";

            String property = System.getProperty("user.dir");
            System.out.println(property);
            String replace = name.replace(".", "/");
            filePath = property + filePath;
            filePath = filePath + replace;
            return filePath;
        }else{
            return filePath;
        }


    }


    /**
     * 更新properties文件的键值对 如果该主键已经存在，更新该主键的值； 如果该主键不存在，则插件一对键值。
     *
     * @param keyname  键名
     * @param keyvalue 键值
     */
    public static void updateProperties(String keyname, String keyvalue) {

        String filePath = getFilePath();
        // 如果文件夹不存在就创建

        System.out.println("filpath="+filePath);

        File folder = new File(filePath);
        if (!folder.exists() && !folder.isDirectory()) {
            System.out.println("//不存在");
            folder.mkdirs();
        }
        // 如果文件不存在就创建
        File file = new File(filePath + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Properties props = new Properties();
        try {
            // 读取文件
            FileInputStream fis = new FileInputStream(filePath + fileName);
            props.load(fis);
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            OutputStream fos = new FileOutputStream(filePath + fileName);
            props.setProperty(keyname, keyvalue);
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            props.store(fos, "Update '" + keyname + "' value");
        } catch (IOException e) {
            System.err.println("属性文件更新错误");
        }
    }
}
