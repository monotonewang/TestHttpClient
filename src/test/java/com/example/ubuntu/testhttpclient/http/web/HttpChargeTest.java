package com.example.ubuntu.testhttpclient.http.web;

import com.example.ubuntu.testhttpclient.http.base.HttpBaseApplicationJson;
import org.junit.Test;

public class HttpChargeTest {


    /**
     * 充值卡充值
     */
    @Test
    public void charge() {
        HttpBaseApplicationJson.postFormByApplicationJson(new Object[][]{
                {"rechargeType", "0"},
                {"rechargeAmt", "53"},
                {"useOrCardId", "1"},
                {"rechargeMode", "1"},
                {"payWay", "1"},
                {"payType", "9"},
                {"orderChannel", "2"},
        }, "/order-recharge/card-wallet");
    }

}
