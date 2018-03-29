package com.example.ubuntu.testhttpclient.webapp;

import com.example.ubuntu.testhttpclient.http.base.HttpGetFormTest;

import org.junit.Test;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class HttpChargeTest {

    @Test
    public void webCharge() {
        HttpGetFormTest.get(new Object[][]{{
                "rechargeType", "0"},
                {"rechargeAmt", "1000"},
                {"userOrCardId", "106"},
                {"rechargeMode", "2"},
                {"payWay", "9"},
                {"payType", "9"},
                {"orderChannel", "9"},
        }, "/charging/scanCharging");
    }

}
