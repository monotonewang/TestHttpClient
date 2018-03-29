package com.example.ubuntu.testhttpclient.http.base;

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
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于测试 application/x-www-form-urlencoded
 * Created by ubuntu on 17-7-11.
 */

public class HttpGetFormTest {

    int index = 2;
//    String url = getFieldValue(clazz) + getPostValue(index, clazz);


    Object[][] string = {//key--value
            {"telephone", "121212"},
    };
    Object[][] checkTelString = {//key--value
            {"telephone", "121212"},
            {"unionType", "1"},
    };

    String debugCheckMobile = "/user/anno/checkReg";//判断手机是否被注册
    String debugCheckTel = "/user/anno/checkTel";//第三方绑定手机号时，判断手机号是否被绑定过
    String debugSaveSearchHistory = "/userSearchHistory/insert";//第三方绑定手机号时，判断手机号是否被绑定过

    @Test
    public void testCheckTel() {
        HttpGetFormTest.get(checkTelString, debugCheckTel);
    }


    String debugGetUserInfo = "/user/getUserInfo";//第三方绑定手机号时，判断手机号是否被绑定过

    Object[][] getUserInfo = {//key--value
            {"telephone", "18966161014"},

    };



    /**
     * 获取用户信息
     */
    @Test
    public void testGetUserInfo() {
        HttpGetFormTest.get(getUserInfo, debugGetUserInfo);
    }

    /**
     * 判断充电站是否被收藏过
     */
    @Test
    public void checkCollect() {
        HttpGetFormTest.get(new Object[][]{{"chargingStationId","2"}}, "/user-collect/checkCollect");
    }


    @Test
    public void testCheckPhone() {
        HttpGetFormTest.get(string, debugCheckMobile);
    }

    Object[][] saveSearchHistoryString = {//key--value
            {"searchType", "1"},
            {"content", "杭州市"},
    };



    @Test
    public void testNoReadMessageAndCoup() {
        HttpBaseApplicationJson.postFormByApplicationJson(new Object[][]{}, "/user/getNoReadMessageAndCoup");
    }


    public static void get(Object[][] string, String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();// 创建默认的httpClient实例.
        url=HttpUserLoginTest.getBaseUrl(HttpUserLoginTest.http_status)+url;
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



    /**
     * 保存用户搜索历史
     */
    @Test
    public void testSaveSearchHistory() {
        HttpBaseApplicationJson.postFormByApplicationJson(saveSearchHistoryString, debugSaveSearchHistory);
    }
}
