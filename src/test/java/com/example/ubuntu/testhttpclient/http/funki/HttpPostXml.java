package com.example.ubuntu.testhttpclient.http.funki;

import com.example.ubuntu.testhttpclient.http.HttpUserLoginTest;
import com.google.gson.JsonObject;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ubuntu on 17-9-1.
 */

public class HttpPostXml {

    public static void postFormByXml(Object[][] string, String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();// 创建默认的httpClient实例.
        System.out.println("url=" + url);
        HttpPost httppost = new HttpPost(url);        // 创建httppost

        httppost.addHeader("Content-type", "application/x-www-form-urlencoded");
//        httppost.setHeader("Accept", "application/json");
        JsonObject j = new JsonObject();
        for (int x = 0; x < string.length; x++) {
            for (int y = 0; y < string[x].length; y++) {
                String key = (String) string[x][0];
                Object value = string[x][1];
                if (value instanceof String) {
                    String value1 = (String) value;
                    j.addProperty(key, value1);
                } else if (value instanceof Integer) {
                    Integer value1 = (Integer) value;
                    j.addProperty(key, value1);
                } else if (value instanceof Boolean) {
                    Boolean value2 = (Boolean) value;
                    j.addProperty(key, value2);
                }
            }
        }
        Header[] allHeaders = httppost.getAllHeaders();
        for (Header header : allHeaders) {
            System.out.println(header.getName() + "---" + header.getValue());
        }
        String stringRes = j.toString();
        System.out.println("stringRes=" + stringRes);


        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//传递2个参数  name和password
        nvps.add(new BasicNameValuePair("telephone", "121212"));
        nvps.add(new BasicNameValuePair("handleType", "1"));
//转码  封装成请求实体
        HttpEntity reqEntity = new UrlEncodedFormEntity(nvps, Consts.UTF_8);


//        httppost.setEntity(new StringEntity(stringRes, Charset.forName("UTF-8")));
        httppost.setEntity(reqEntity);
        try {
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("length" + entity.getContentLength());
                    System.out.println(EntityUtils.toString(entity, "UTF-8"));
//                    System.out.println("Response content: \n" + EntityUtils.toString(entity, "UTF-8"));
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void postFormByApplicationJson(Object[][] string, String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();// 创建默认的httpClient实例.
        System.out.println("url=" + url);
        HttpPost httppost = new HttpPost(url);        // 创建httppost
        httppost.addHeader("token", HttpUserLoginTest.token);
        httppost.addHeader("funkiSystem", "androidFunki");
        httppost.addHeader("softwareName", "androidFunki");
        httppost.addHeader("imei", "androidFunki");
        httppost.addHeader("session", "");
        httppost.addHeader("system", "Android5.0");
        httppost.addHeader("deviceName", "Mi-4C");
        httppost.addHeader("deviceType", "android8");
        httppost.addHeader("ip", "125.120.81.6");
        httppost.addHeader("geo", "{}");
        httppost.addHeader("isBreak", "1");
        httppost.addHeader("funkiVersion", "1.2.1");

        httppost.addHeader("Content-type", "application/json");
        httppost.setHeader("Accept", "application/json");
        JsonObject j = new JsonObject();
        for (int x = 0; x < string.length; x++) {
            for (int y = 0; y < string[x].length; y++) {
                String key = (String) string[x][0];
                Object value = string[x][1];
                if (value instanceof String) {
                    String value1 = (String) value;
                    j.addProperty(key, value1);
                } else if (value instanceof Integer) {
                    Integer value1 = (Integer) value;
                    j.addProperty(key, value1);
                } else if (value instanceof Boolean) {
                    Boolean value2 = (Boolean) value;
                    j.addProperty(key, value2);
                }
            }
        }
        Header[] allHeaders = httppost.getAllHeaders();
        for (Header header : allHeaders) {
            System.out.println(header.getName() + "---" + header.getValue());
        }
        String stringRes = j.toString();
        System.out.println("stringRes=" + stringRes);
        httppost.setEntity(new StringEntity(stringRes, Charset.forName("UTF-8")));
        try {
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("length" + entity.getContentLength());
                    System.out.println(EntityUtils.toString(entity, "UTF-8"));
//                    System.out.println("Response content: \n" + EntityUtils.toString(entity, "UTF-8"));
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
