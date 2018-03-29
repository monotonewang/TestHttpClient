package com.example.ubuntu.testhttpclient.http.user;


import com.example.ubuntu.testhttpclient.http.HttpUserLoginTest;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于测试 application/x-www-form-urlencoded
 * Created by ubuntu on 17-7-11.
 */

public class HttpUserGetTest {

    public static void get(Object[][] string, String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();// 创建默认的httpClient实例.
        url= HttpUserLoginTest.getBaseUrl(HttpUserLoginTest.http_status)+url;
        System.out.println("url=" + url);
        HttpGet httpGet = null;
//        httpGet.addHeader("Content-type", "application/json; charset=utf-8");
//        httpGet.addHeader("Content-type", "application/x-www-form-urlencoded");
//        httpGet.addHeader("Content-type", "text/xml");
        //封装请求参数
        List<NameValuePair> params = new ArrayList<>();

        for (int x = 0; x < string.length; x++) {
//            for (int y = 0; y < string[x].length; y++) {
            String key = (String) string[x][0];
            Object value = string[x][1];
            if (value instanceof String) {
                String value1 = (String) value;

                params.add(new BasicNameValuePair(key, (String) value1));
            } else if (value instanceof Integer) {
                Integer value1 = (Integer) value;
            } else if (value instanceof Boolean) {
                Boolean value2 = (Boolean) value;
            }
//            }
        }

        String str = "";
        try {
            //转换为键值对
            str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
            System.out.println(str);

            httpGet = new HttpGet(url + "?" + str);
            httpGet.addHeader("token", HttpUserLoginTest.token);
            Header[] allHeaders = httpGet.getAllHeaders();
            System.out.println("headersLength=" + allHeaders.length);
            for (int i = 0; i < allHeaders.length; i++) {
                System.out.println("header=name==" + allHeaders[i].getName() + "|||||||||value=" + allHeaders[i].getValue());
            }
        } catch (Exception e) {

        }

        try {
            System.out.println("executing request " + httpGet.getURI());
            CloseableHttpResponse response = httpClient.execute(httpGet);
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
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }






}
