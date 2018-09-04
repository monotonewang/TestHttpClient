package com.example.ubuntu.testhttpclient.http.weixue;

import com.example.ubuntu.testhttpclient.http.HttpUserLoginTest;
import com.example.ubuntu.testhttpclient.http.funki.HttpFormTest;
import com.example.ubuntu.testhttpclient.http.funki.HttpGetFormTestx;
import org.junit.Test;

import java.util.HashMap;

public class HttpWeixueTest {

//    https://test.eweixue.com/v1/organization/recommend_course/list?per_page=10&organization_id=Jb71kNvY&page=1&is_organization=1&version=1139&platform=android&token=yDtjJQ8fEdkQRFUY


    public enum HTTP_STATUS {
        test, release
    }

    //        public static HTTP_STATUS http_status = HTTP_STATUS.sxq;
    public static HTTP_STATUS http_status = HTTP_STATUS.test;

    public static String getBaseUrl(HTTP_STATUS http_status) {
        switch (http_status) {
            case test:
                return "https://test.eweixue.com";
            case release:
                return "https://api.eweixue.com";
            default:
                return "";
        }
    }

    @Test
    public void login() {
        HashMap hashMap = new HashMap<>();

        hashMap.put("mobile", "13634133426");
        hashMap.put("code", "1234");
        hashMap.put("password", "xxx");
        HttpFormTest.postFormByForm(hashMap, getBaseUrl(http_status) + "/v1/user/auth/login");

    }

    @Test
    public void getCode() {
        HashMap hashMap = new HashMap<>();

        hashMap.put("mobile", "13634133426");
        HttpGetFormTestx.getForm(hashMap, getBaseUrl(http_status) + "/v1/user/auth/get_code");


    }

    @Test
    public void getCodeAndLogin() {
        HashMap hashMap = new HashMap<>();

        hashMap.put("mobile", "13634133426");
        HttpGetFormTestx.getFormString(hashMap, getBaseUrl(http_status) + "/v1/user/auth/get_code");

        HashMap hashMapX = new HashMap<>();

        hashMapX.put("mobile", "13634133426");
        hashMapX.put("code", "1234");
        hashMapX.put("password", "xxx");
        HttpFormTest.postFormByForm(hashMap, getBaseUrl(http_status) + "/v1/user/auth/login");
    }


}
