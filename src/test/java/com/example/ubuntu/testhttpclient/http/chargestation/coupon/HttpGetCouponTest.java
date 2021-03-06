package com.example.ubuntu.testhttpclient.http.chargestation.coupon;


import com.example.ubuntu.testhttpclient.http.base.HttpBaseApplicationJson;
import com.example.ubuntu.testhttpclient.http.base.HttpGetFormTest;

import org.junit.Test;

/**
 * Created by zgjxf on 2017/12/22.
 */

public class HttpGetCouponTest {

    @Test
    public void availCouponList() {
        HttpGetFormTest.get(new Object[][]{
                {"couponType", "1"},
                {"currentAmount", "12"},
                {"usingRange", "1"},
        }, "/user-coupon/availCouponList");
    }

    @Test
    public void getCouponList() {
        HttpGetFormTest.get(new Object[][]{

        }, "/user-coupon/getUserCouponList");
    }

    @Test
    public void updateNOReadCoupon() {
        HttpBaseApplicationJson.postFormByApplicationJson(new Object[][]{}, "/user-coupon/updateNOReadCoupon");
    }
}
