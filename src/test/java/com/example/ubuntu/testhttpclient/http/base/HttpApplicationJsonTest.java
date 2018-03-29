package com.example.ubuntu.testhttpclient.http.base;

import com.google.gson.GsonBuilder;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.charset.Charset;


/**
 * application/json
 * Created by ubuntu on 17-7-12.
 */

public class HttpApplicationJsonTest {

    int index = 2;
    //    String url = getFieldValue(clazz) + getPostValue(index, clazz);
//        String url = "http://35.164.1.183:7000/user/user/personalInfo/get";//获取编辑个人资料
//        String url = "http://35.164.1.183:7000/user/user/tags/get";//获取个人标签
//        String url = "http://35.164.1.183:7000/user/user/personalInfo/languages/get";//获取语言列表
//        String url = "http://35.164.1.183:7000/user/user/personalInfo/edit";
String url = "http://app.hifunki.com/dev_microblog/api/getBlogInfo";//批量读取动态详情

//shop
//String url="http://app.hifunki.com/dev_shop/products/all";
    //user
//    String url = "http://app.hifunki.com/dev_user/user/personalInfo/edit";
//    String url = "http://app.hifunki.com/dev_user/user/album/delete";

    public class MyEntity {
        int page;
        int perPage;
    }

    /**
     * 获取实体类
     *
     * @return
     */
//    public Object getEntity() {
//        EditProfileRequestEntity entity = new EditProfileRequestEntity();
//        entity.userId = 461;
//        EditProfileEntity entity1 = new EditProfileEntity();
//        entity1.nickName = "123";
//        entity.data = entity1;
//        return entity;
//    }

    /**
     * 删除个人相册
     * @return
     */
    public JSONObject getAlbumDelete() {
        JSONArray array = new JSONArray();
        array.put(121);
        array.put(122);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("images", array);
            jsonObject.put("userId", 422);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 用于请求个人中心tag
     *
     * @return
     * @throws JSONException
     */
    public JSONObject getJsonObject() throws JSONException {
        JSONArray array = new JSONArray();
        array.put("599cf91e455f4ac62420108a");
//        array.put(2);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("blogIds", array);
//        jsonObject.put("code", "1");
//        jsonObject.put("level", "1");

//        JSONObject jsonObjectxx = new JSONObject();
//        jsonObjectxx.put("languages", jsonObject);

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("userId", 2);// 红谷滩新闻资讯，channelId 77
        jsonParam.put("blogIds", array);// 标题
//
        return jsonParam;
    }
//    {"language":str(语言名称),"code":str(编码),"level":int(语言等级)}

    /**
     * 用于测试 application/json 方式请求
     */
    @Test
    public void postByApplicationJson() throws JSONException {
        GsonBuilder gsonBuilder = new GsonBuilder();
//        String string = gsonBuilder.create().toJson(getEntity());

//        String string = getAlbumDelete().toString();
        String string= getJsonObject().toString();
        System.out.println("string=" + string);
        CloseableHttpClient httpclient = HttpClients.createDefault();// 创建默认的httpClient实例.
        System.out.println("url=" + url);
        HttpPost httppost = new HttpPost(url);        // 创建httppost
        httppost.addHeader("Content-type", "application/json; charset=utf-8");
        httppost.setHeader("Accept", "application/json");
        //print heads
        Header[] allHeaders = httppost.getAllHeaders();
        for (int i = 0; i < allHeaders.length; i++) {
            System.out.println(allHeaders[i]);
        }
        StringEntity entity = new StringEntity(string, Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httppost.setEntity(entity);
        try {
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);

            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("statusCode=" + statusCode);
            try {
                HttpEntity entityx = response.getEntity();
                if (entityx != null) {
                    System.out.println("length" + entityx.getContentLength());
                    System.out.println("--------------------------------------");
                    System.out.println("Response content: " + EntityUtils.toString(entityx, "UTF-8"));
                    System.out.println("--------------------------------------");
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

    /**
     * 获取类属性的value
     *
     * @param tClass
     * @param <T>
     * @return
     */
//    public <T> String getFieldValue(Class<T> tClass) {
//        Class<UserApi> clazz = UserApi.class;
//
//        Field[] fieldsx = clazz.getDeclaredFields();
//        for (Field field : fieldsx) {
//            System.out.println(field.getName());
//            field.setAccessible(true);
//            try {
//                String anInt = (String) field.get(null);
//                return anInt;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return "";
//    }

    /**
     * 获取Retrofit前面的url
     *
     * @param index
     * @param clazz
     * @return
     * @throws NoSuchMethodException
     */
//    public String getPostValue(int index, Class clazz) {
//        Method[] declaredMethods = clazz.getDeclaredMethods();
//        System.out.println(declaredMethods.length);
//        Annotation[] declaredAnnotations = declaredMethods[index].getDeclaredAnnotations();
//        String xx = "";
//        for (int k = 0; k < declaredAnnotations.length; k++) {
//            for (Annotation annotation : declaredAnnotations) {
//                if (annotation instanceof POST) {
//                    POST param = (POST) annotation;
//                    xx = param.value();
//                }
//            }
//        }
//        return xx;
//    }

}
