package com.example.ubuntu.testhttpclient.http.account;


import com.example.ubuntu.testhttpclient.http.base.HttpBaseApplicationJson;
import com.example.ubuntu.testhttpclient.http.base.HttpGetFormTest;

import org.junit.Test;

/**
 * Created by zgjxf on 2017/12/5.
 */

public class HttpAccountTest {


    @Test
    public void balance() {
        HttpGetFormTest.get(new Object[][]{
                {"accountType","0"}
        }, "/account/balance");
    }


    @Test
    public void appoint() {
        HttpBaseApplicationJson.postFormByApplicationJson(new Object[][]{
                {"chargingId", "22"},
                {"chargingPileId", "5"},
                {"type", "2"},
        }, "/appointment/appoint");
    }


    @Test
    public void startCharge() {
        HttpBaseApplicationJson.postFormByApplicationJson(new Object[][]{
                {"chargingId", "22"},
                {"chargingPileId", "5"},
                {"type", "3"},
                {"chg", "0"},
                {"model", "1"},
                {"orderChannel", "1"},
        }, "/charging/startCharging");
    }

    @Test
    public void getAppoint() {
        HttpGetFormTest.get(new Object[][]{

        }, "/appointment/getAppoint");
    }

    /**
     * //获取热门城市
     */
    @Test
    public void testGetHotCity() {
        HttpGetFormTest.get(new Object[][]{}, "/station/getHotCity");
    }


    @Test
    public void scanCharging() {
        HttpGetFormTest.get(new Object[][]{{
                "chargingId", "1"},
                {"chargingPileId", "1"},
        }, "/charging/scanCharging");
    }

    /**
     * 获取用户预约充电枪信息
     */
    @Test
    public void testGetAppointment() {
        HttpGetFormTest.get(new Object[][]{}, "/appointment/getAppoint");
    }

    @Test
    public void orderComment() {
        HttpGetFormTest.get(new Object[][]{
                {"userId", "1"},
                {"orderId", "1"},
                {"orderId", "1"},
        }, "/order-comment/add");
    }

    /**
     * 获取正在充电信息
     */
    @Test
    public void getcharging() {
        HttpGetFormTest.get(new Object[][]{
        }, "/order-charging/getcharging");
    }

    @Test
    public void getChargingDetail() {
        HttpGetFormTest.get(new Object[][]{
        }, "/order-charging/getChargingDetail");
    }


}
