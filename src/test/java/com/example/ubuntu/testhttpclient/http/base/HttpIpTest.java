package com.example.ubuntu.testhttpclient.http.base;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ubuntu on 17-9-11.
 */

public class HttpIpTest {

    String url = "http://ip.taobao.com/service/getIpInfo.php?ip=myip";

    @Test
    public void postTest() {
        CloseableHttpClient httpclient = HttpClients.createDefault();// 创建默认的httpClient实例.
        System.out.println("url=" + url);
        HttpGet httpGet = new HttpGet(url);        // 创建httppost

        try {
            System.out.println("executing request " + httpGet.getURI());
            CloseableHttpResponse response = httpclient.execute(httpGet);
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

    @Test
    public void testUrlConnection() {
        {
            String IP = "";
            try {
                String address = "http://ip.taobao.com/service/getIpInfo2.php?ip=myip";
                URL url = new URL(address);
                HttpURLConnection connection = (HttpURLConnection) url
                        .openConnection();
                connection.setUseCaches(false);

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream in = connection.getInputStream();

// 将流转化为字符串
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(in));

                    String tmpString = "";
                    StringBuilder retJSON = new StringBuilder();
                    while ((tmpString = reader.readLine()) != null) {
                        retJSON.append(tmpString + "\n");
                    }

                    JSONObject jsonObject = new JSONObject(retJSON.toString());
                    int code = jsonObject.getInt("code");
                    if (code==0) {
                        JSONObject data = jsonObject.getJSONObject("data");
                        IP = data.getString("ip");
                        System.out.println(IP);
                    } else {
                        IP = "";
                        System.out.println("IP接口异常，无法获取IP地址！");
                    }
                } else {
                    IP = "";
                    System.out.println("网络连接异常，无法获取IP地址！");
                }
            } catch (Exception e) {
                IP = "";
            }
        }
    }
}
