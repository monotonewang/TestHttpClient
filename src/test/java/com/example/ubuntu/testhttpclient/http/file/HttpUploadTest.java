//package com.example.ubuntu.testhttpclient.http.file;
//
//
//import com.example.ubuntu.testhttpclient.http.HttpUserLoginTest;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.junit.Test;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.InputStreamReader;
//
///**
// * Created by Administrator on 2017/12/14 0014.
// */
//
//public class HttpUploadTest {
//
//    @Test
//    public void testHttpUpload() {
//
//    }
//
//    @Test
//    public void uploadFileImpl() throws Exception {
////        File file = new File("FengChao_v1.0_2017-12-26_11-23-41_wandoujia.apk");
//        File file = new File("1514267205448.png");
//        if (file.length() <= 0) return;
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        CloseableHttpResponse httpResponse = null;
//        HttpPost httpPost = new HttpPost(HttpUserLoginTest.getBaseUrl(HttpUserLoginTest.http_status) + "/image/upload");
//        httpPost.addHeader("token",HttpUserLoginTest.token);
//        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
//        multipartEntityBuilder.addBinaryBody("file", file);
//        multipartEntityBuilder.addTextBody("comment", "this is comment");
//        HttpEntity httpEntity = multipartEntityBuilder.build();
//        httpPost.setEntity(httpEntity);
//        httpResponse = httpClient.execute(httpPost);
//        HttpEntity responseEntity = httpResponse.getEntity();
//        int statusCode = httpResponse.getStatusLine().getStatusCode();
//        if (statusCode == 200) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(responseEntity.getContent()));
//            StringBuffer buffer = new StringBuffer();
//            String str = "";
//            while ((str = reader.readLine()) != null) {
//                buffer.append(str);
//            }
//            System.out.println(buffer.toString());
//        }
//        httpClient.close();
//        httpResponse.close();
//        return;
//    }
//
//}
