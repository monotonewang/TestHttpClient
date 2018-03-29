package com.example.ubuntu.testhttpclient.http.station;


import com.example.ubuntu.testhttpclient.http.HttpUserLoginTest;

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
import java.util.List;

/**
 * 用于测试 application/x-www-form-urlencoded
 * Created by ubuntu on 17-7-11.
 */

public class HttpGetStationTest {

    int index = 2;
//    String url = getFieldValue(clazz) + getPostValue(index, clazz);

    String getSysParam = "/sysParam/getAll";//获取故障类型

    Object[][] SysString = {//key--value
            {"paramType", "FAULT_REPORT_TYPE"},
    };


    @Test
    public void getAppoint(){

        HttpGetStationTest.get(new Object[][]{}, "/appointment/getAppoint");

    }
    /**
     * 获取所有充电站点
     */
    @Test
    public void getALLStationWithVersion() {

        HttpGetStationTest.get(new Object[][]{}, "/station/getAllData");

    }

    @Test
    public void getALLStationNew() {
        HttpGetStationTest.get(new Object[][]{
                {"version", "1"},
        }, "/versionManage/getList");
    }


    /**
     * 故障上报
     */
    @Test
    public void getSysParam() {
        HttpGetStationTest.get(SysString, getSysParam);
    }

    @Test
    public void getUnFinished() {
        HttpGetStationTest.get(new Object[][]{}, "/charging/unFinished");
    }

    Object[][] string = {//key--value
            {"id", "2"},
    };

    Object[][] stringGetCharging = {//key--value
            {"chargingStationId", "2"},
    };

    @Test
    public void testGetAllStation() {
        HttpGetStationTest.get(new Object[][]{
                {"id", "46"},
        }, getAllData);
    }

    @Test
    public void testGetStationDetail() {

        HttpGetStationTest.get(new Object[][]{
                {"id", "46"},
        }, getStation);
    }

    /**
     * 二维码扫描
     */
    @Test
    public void scanCharging() {
        HttpGetStationTest.get(
                new Object[][]{
                        {"chargingId", "22"},
                        {"chargingPileId", "5"},
                },
                "/charging/scanCharging");
    }

    /**
     * 根据桩号获取充电枪信息
     */
    @Test
    public void getCharging() {
        HttpGetStationTest.get(
                new Object[][]{
                        {"pileNo", "EN10703168300712"},
                },
                "/charging/getCharging");
    }

    /**
     * 获取充电站+充电枪列表信息
     */
    @Test
    public void testGetChargeingList() {
        HttpGetStationTest.get(stringGetCharging, GetChargingList);
    }

    /**
     * 获取充电站+充电枪列表信息
     */
    @Test
    public void testFaultCreate() {
        HttpGetStationTest.get(new Object[][]{}, FaultCreate);
    }

    /**
     * 获取充电站+充电枪列表信息
     */
    @Test
    public void testGetHotCity() {
        HttpGetStationTest.get(new Object[][]{}, GetHotCity);
    }

    Object[][] stringGetStationList = {//key--value
            {"page", "1"},
            {"size", "10"},
            {"orderBy", "1"},
    };


    @Test
    public void testGetStationDetailList() {
        HttpGetStationTest.get(new Object[][]{
                        {"page", "1"},
                        {"size", "10"},
                        {"orderBy", "1"},
                },
                GetStationList);
    }

    @Test
    public void testGetStationComments() {
        HttpGetStationTest.get(stringGetComments, getComments);
    }

    Object[][] stringGetComments = {//key--value
            {"id", "2"},
            {"page", "1"},
            {"size", "10"},
    };

    @Test
    public void testGetStationRemote() {
        HttpGetStationTest.get(stringGetComments, getComments);
    }

    Object[][] stringGetAllRepairStation = {//key--value
            {"page", "1"},
            {"size", "10"},
    };

    @Test
    public void testGetRepairStation() {
        HttpGetStationTest.get(stringGetAllRepairStation, GetAllRepairStation);
    }

    String GetAllRepairStation = "/repair-station/getall";
    String getComments = "/station/getComments";//获取所有的
    String getAllData = "/station/getAllData";//获取所有的
    String getStation = "/station/get";//获取站点详情
    String GetChargingList = "/charging/getList";//获取站点详情
    String FaultCreate = "/fault/create";//故障上报
    String GetHotCity = "/station/getHotCity";//故障上报
    String GetStationList = "/station/getall";//获取充电站列表

    public static void get(Object[][] string, String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();// 创建默认的httpClient实例.
        System.out.println("url=" + url);
        HttpGet httpGet = null;
//        httpGet.addHeader("Content-type", "application/json; charset=utf-8");
//        httpGet.addHeader("Content-type", "application/x-www-form-urlencoded");

        //封装请求参数
        List<NameValuePair> params = new ArrayList<>();
        for (int x = 0; x < string.length; x++) {
            String key = (String) string[x][0];
            Object value = string[x][1];
            if (value instanceof String) {
                String value1 = (String) value;

                params.add(new BasicNameValuePair(key, value1));
            } else if (value instanceof Integer) {
                Integer value1 = (Integer) value;
            } else if (value instanceof Boolean) {
                Boolean value2 = (Boolean) value;
            }
        }
        String stringRes = params.toString();
        System.out.println("request=" + stringRes);
//        params.add(new BasicNameValuePair("telephone", "121212"));

        String str = "";
        try {
            //转换为键值对
            str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
            System.out.println(str);

            httpGet = new HttpGet(HttpUserLoginTest.getBaseUrl(HttpUserLoginTest.http_status) + url + "?" + str);
            httpGet.addHeader("token", HttpUserLoginTest.token);

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
/*
    public static void getStation(Object[][] string, String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();// 创建默认的httpClient实例.
        System.out.println("url=" + url);
        HttpGet httpGet = null;
//        httpGet.addHeader("Content-type", "application/json; charset=utf-8");
//        httpGet.addHeader("Content-type", "application/x-www-form-urlencoded");
//        httpGet.addHeader("Content-type", "text/xml");

//        {"page", 1},
//        {"size", 10},
//        {"orderBy", 1},

        //封装请求参数
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("page",""));
        for (int x = 0; x < string.length; x++) {
            for (int y = 0; y < string[x].length; y++) {
                String key = (String) string[x][0];
                Object value = string[x][1];
                if (value instanceof String) {
                    String value1 = (String) value;

                    params.add(new BasicNameValuePair(key, value1));
                } else if (value instanceof Integer) {
                    Integer value1 = (Integer) value;
                } else if (value instanceof Boolean) {
                    Boolean value2 = (Boolean) value;
                }
            }
        }
        String stringRes = params.toString();
        System.out.println("request=" + stringRes);
//        params.add(new BasicNameValuePair("telephone", "121212"));

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
    }*/
