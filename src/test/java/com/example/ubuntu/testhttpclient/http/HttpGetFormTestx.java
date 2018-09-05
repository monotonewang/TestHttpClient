package com.example.ubuntu.testhttpclient.http;

import com.google.gson.JsonObject;

import com.google.gson.JsonParser;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 用于测试 application/x-www-form-urlencoded
 * Created by ubuntu on 17-7-11.
 */

public class HttpGetFormTestx {

    int index = 2;
//    String url = getFieldValue(clazz) + getPostValue(index, clazz);


    Object[][] string = {//key--value
            {"telephone", "121212"},
    };


//auth
//String url = "http://app.hifunki.com/dev_auth/background/user/seal/cancel";//解封处理
//String url = "http://app.hifunki.com/dev_auth/background/user/feng/cancel";//时效性解封处理
//String url = "http://app.hifunki.com/dev_auth/login/byEmail";//邮箱登录
//String url = "http://app.hifunki.com/dev_auth/register/username/add";//添加用户名
//String url = "http://35.164.1.183:7000/auth/register/byEmail";//邮箱注册
//String url = "http://35.164.1.183:7000/auth/login/userInfo/get";//隐私与安全获取用户信息
//String url = "http://35.164.1.183:7000/auth/login/out";//退出
//String url = "http://35.164.1.183:7000/auth/login/password/check";//使用userId,校验密码
//String url = "http://35.164.1.183:7000/auth/register/getEmailCode";//获取邮箱验证码
//String url = "http://35.164.1.183:7000/auth/register/email/check";//校验邮箱验证码

    String debugCheckMobile = "/user/anno/checkReg";//判断手机是否被注册


    /**
     * get form 请求
     *
     * @param hashMap
     * @param url
     */
    public static void getForm(HashMap<String, String> hashMap, String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();// 创建默认的httpClient实例.
        System.out.println("url=" + url);
        HttpGet httpGet = null;
//        httpGet.addHeader("Content-type", "application/json; charset=utf-8");
//        httpGet.addHeader("Content-type", "application/x-www-form-urlencoded");
//        httpGet.addHeader("Content-type", "text/xml");
        JsonObject j = new JsonObject();
        List<NameValuePair> params = new ArrayList<>();

        for (String key : hashMap.keySet()) {
            System.out.println("Key: " + key + " Value: " + hashMap.get(key));
            j.addProperty(key, hashMap.get(key));
            params.add(new BasicNameValuePair(key, hashMap.get(key)));

        }
        String stringRes = j.toString();
        System.out.println("stringRes=" + stringRes);
        //封装请求参数
        String str = "";
        try {
            //转换为键值对
            str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
            System.out.println(str);

            httpGet = new HttpGet(url + "?" + str);


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


    public static void postFormByApplicationJson(Object[][] string, String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();// 创建默认的httpClient实例.
        System.out.println("url=" + url);
        HttpGet httpGet = null;
//        httpGet.addHeader("Content-type", "application/json; charset=utf-8");
//        httpGet.addHeader("Content-type", "application/x-www-form-urlencoded");
//        httpGet.addHeader("Content-type", "text/xml");
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
        String stringRes = j.toString();
        System.out.println("stringRes=" + stringRes);

        //封装请求参数
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("telephone", "121212"));
        String str = "";
        try {
            //转换为键值对
            str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
            System.out.println(str);

            httpGet = new HttpGet(url + "?" + str);


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

    @Test
    public void testCheckPhone() {
        HttpGetFormTestx.postFormByApplicationJson(string, debugCheckMobile);
    }


    public static JsonObject getFormString(HashMap<String, String> hashMap, String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();// 创建默认的httpClient实例.
        System.out.println("url=" + url);
        HttpGet httpGet = null;
//        httpGet.addHeader("Content-type", "application/json; charset=utf-8");
//        httpGet.addHeader("Content-type", "application/x-www-form-urlencoded");
//        httpGet.addHeader("Content-type", "text/xml");
        JsonObject j = new JsonObject();
        List<NameValuePair> params = new ArrayList<>();

        for (String key : hashMap.keySet()) {
//            System.out.println("Key: " + key + " Value: " + hashMap.get(key));
            j.addProperty(key, hashMap.get(key));
            params.add(new BasicNameValuePair(key, hashMap.get(key)));

        }
        String stringRes = j.toString();
        System.out.println("stringRes=" + stringRes);
        //封装请求参数
        String str = "";
        try {
            //转换为键值对
            str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
            System.out.println(str);

            httpGet = new HttpGet(url + "?" + str);


        } catch (Exception e) {

        }


        try {
            System.out.println("executing request " + httpGet.getURI());
            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("length" + entity.getContentLength());
                    String jsonstr = EntityUtils.toString(entity, "UTF-8");
                    System.out.println(jsonstr);

                    JsonObject returnData = new JsonParser().parse(jsonstr).getAsJsonObject();
                    String code = returnData.get("code").getAsString();
                    System.out.println( code +"code=");
                    return returnData;
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
        return null;
    }

}
