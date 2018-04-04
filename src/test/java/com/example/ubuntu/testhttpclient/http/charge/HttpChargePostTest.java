package com.example.ubuntu.testhttpclient.http.charge;


import com.example.ubuntu.testhttpclient.http.base.HttpBaseApplicationJson;
import com.example.ubuntu.testhttpclient.http.base.HttpGetFormTest;

import org.junit.Test;

/**
 * Created by zgjxf on 2017/12/5.
 */

public class HttpChargePostTest {

    @Test
    public void getStaitonNew(){
        HttpGetFormTest.get(new Object[][]{
                {"id", "4"},
        },"/station/get");
    }

    /**
     * 充电枪两元判断
     */
    @Test
    public void checkBalance(){
        HttpGetFormTest.get(new Object[][]{},"/charging/checkBalance");
    }

    @Test
    public void getUnFinish() {
        HttpGetFormTest.get(new Object[][]{

        }, "/charging/unFinished");
    }

    public void getCharging(){
        HttpGetFormTest.get(new Object[][]{
                {"pileNo", "EN10703168300712"},
        }, "/charging/getCharging");
    }


    /**
     * 获取用户充电记录列表
     */
    @Test
    public void getAllOrderCharging(){
        HttpGetFormTest.get(new Object[][]{
                {"page", "1"},
                {"size", "10"},
        }, "/order-charging/getall");
    }

    @Test
    public void getChargingList(){
        HttpGetFormTest.get(new Object[][]{
                {"size", "10"},
                {"page", "1"},
        }, "/order-charging/getall");
    }


    @Test
    public void getUnpaidOrder() {
        HttpGetFormTest.get(new Object[][]{

        }, "/order-info/getUnpaidOrder");
    }

    @Test
    public void getNewestVersion(){
        HttpGetFormTest.get(new Object[][]{

        }, "/versionManage/getNew");
    }
    @Test
    public void getVersionStation(){
        HttpGetFormTest.get(new Object[][]{
                {"version", "57"},
        }, "/versionManage/getList");
    }

    @Test
    public void appoint() {
        HttpBaseApplicationJson.postFormByApplicationJson(new Object[][]{
                {"chargingId", "82"},
                {"chargingPileId", "53"},
                {"type", "1"},
        }, "/appointment/appoint");
    }


    /**
     * 新二维码扫描
     */
    @Test
    public void ScanCharginTest() {
        HttpGetFormTest.get(new Object[][]{
                {"chargingNo", "1"},
                {"pileNo", "EN10703168300712"},
                {"appType", "2"},
        }, "/chargingScan/scanCharging");
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
