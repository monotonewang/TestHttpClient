package com.example.ubuntu.testhttpclient.http;


import com.example.ubuntu.testhttpclient.http.base.HttpBaseApplicationJson;

import org.junit.Test;

/**
 * Created by zgjxf on 2017/12/5.
 */

public class HttpUserLoginTest {


    public enum HTTP_STATUS {
        sxq, caiwei, develop, test,fxq,shiyong
    }

    //        public static HTTP_STATUS http_status = HTTP_STATUS.sxq;
    public static HTTP_STATUS http_status = HTTP_STATUS.test;

    public static String getBaseUrl(HTTP_STATUS http_status) {
        switch (http_status) {
            case sxq:
                return "http://192.168.10.123:9093";
            case caiwei:
                return "http://192.168.10.25:9093";
            case develop:
                return "http://192.168.10.116:9092";
            case test:
                return "http://118.178.224.151:9093";
            case fxq:
                return "http://ffq.4kb.cn";
            case shiyong:
                return "http://118.178.224.151:6003";
            default:
                return "";
        }
    }


    //    123321
//    18727171544 yunlong
//    15381042981 fanjia
    // 13634133426 password 123321212
    Object[][] phoneLoginTest = {//key-- value
            {"telephone", "18616772548"},
            {"password", "12345678"},
            {"loginType", 1},//1-手机号登录，2-第三方登录
            {"deviceToken", "tetsslkfdsnjfkldsnfdlskfall12121221"},
    };
//    {"deviceType", "13634133426"},
//    {"deviceName", "13634133426"},
//    {"deviceInfo", "13634133426"},
//    {"deviceVersion", "13634133426"},
//    {"channel", "13634133426"},
//    {"pushFlag", "13634133426"},


    Object[][] phoneLoginSXQ = {//key-- value
            {"telephone", "13434133421"},
            {"password", "12345678"},
            {"loginType", 1},//1-手机号登录，2-第三方登录
    };
    Object[][] phoneLoginsCAIWEI = {//key-- value
            {"telephone", "13750823421  "},
            {"password", "222222"},
            {"loginType", 1},//1-手机号登录，2-第三方登录
    };

  /*Object[][] phoneLoginstring = {//key-- value
            {"telephone", "18966161014"},
            {"password", "63384884sjw"},

            {"loginType", 1},//1-手机号登录，2-第三方登录
    };*/

    Object[][] thirdLoginString = {//key-- value
            {"telephone", ""},
            {"password", ""},
            {"vcode", ""},
            {"unionToken", "4B5296AE2318F4E9CDFF1DEDA748F823"},//第三方唯一Token
            {"unionType", "1"},//登录方式：1-QQ，2-微博，3-微信，10-hwt充值卡
            {"nickname", "傅晴望"},
            {"unionContent", ""},
            {"unionAvatar", "http://q.qlogo.cn/qqapp/1106564086/B65AC6BF436FC01566A2318789375255/100"},
            {"loginType", 2},//1-手机号登录，2-第三方登录
    };

    @Test
    public void testThirdLogin() {
        HttpBaseApplicationJson.postFormByApplicationJson(thirdLoginString, "/user/anno/loginBasic");
    }

    public static String token = "27d5278a6d7d4914b03d9e66a88c3c53";


    @Test
    public void testPhoneLogin() {
        HttpBaseApplicationJson.postFormByApplicationJson(phoneLoginTest, "/user/anno/loginBasic");
    }

    @Test
    public void forTestPhoneLogin() {
        for (int i = 0; i < 100; i++)
            testPhoneLogin();
    }

}
