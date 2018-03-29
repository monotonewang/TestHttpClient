package com.example.ubuntu.testhttpclient;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * Created by zgjxf on 2017/12/7.
 */

public class TestString {

    @Test
    public void testStrig() {
        String icon = "http:\\/\\/q.qlogo.cn\\/qqapp\\/1106564086\\/B65AC6BF436FC01566A2318789375255\\/100";


    }

    @Test
    public void testStringEquals(){
        String encodedPath="/user/getNoReadMessageAndCoup";

        if (!encodedPath.equals("/station/getAllData") && !encodedPath.equals("/versionManage/getList")) {

            System.out.println("xxx");
//            builder.addHeader("token", UserConfigs.getToken()).url(newBuilder.build());

        }
    }

    @Test
    public void testChar() {
        System.out.println(":");
    }

    @Test
    public void testDouble() {
        double d = 12121.121212;
        DecimalFormat decimalFormat = new DecimalFormat("0");
        String format = decimalFormat.format(d);
        System.out.println(format);
    }

    @Test
    public void testReplace() {
        String string = "0110";
        String a = string.replaceFirst("0", "A");
        System.out.println(a);
    }

}
