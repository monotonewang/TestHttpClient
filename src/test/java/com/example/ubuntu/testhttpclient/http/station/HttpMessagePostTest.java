package com.example.ubuntu.testhttpclient.http.station;


import com.example.ubuntu.testhttpclient.http.base.HttpBaseApplicationJson;

import org.junit.Test;

/**
 * Created by zgjxf on 2017/12/5.
 */

public class HttpMessagePostTest {

//    123321
    Object[][] string = {//key--value
            {"telephone", "13434133426"},
            {"vcode", "123321"},
            {"handleType", "1"},

    };

    String sendSmsDebug="/anno/message/sms-send";
    String smsVerifyDebug="/anno/message/sms-verify";

    @Test
    public void testSendSms() {
                HttpBaseApplicationJson.postFormByApplicationJson(string,sendSmsDebug);
    }

    @Test
    public void testSmsVerify(){
        HttpBaseApplicationJson.postFormByApplicationJson(string,smsVerifyDebug);
    }

}
