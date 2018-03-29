package com.example.ubuntu.testhttpclient.http.user;


import com.example.ubuntu.testhttpclient.http.base.HttpBaseApplicationJson;
import com.example.ubuntu.testhttpclient.http.base.HttpGetFormTest;

import org.junit.Test;

/**
 * Created by zgjxf on 2017/12/5.
 */

public class HttpUserPostTest {

    //    123321
    // 13634133426 password 123321212
    Object[][] stringx = {//key-- value
            {"telephone", "13434133421"},
            {"password", "123456789"},
//            {"regChannel", "1"},
//            {"vcode", ""},
////            {"handleType", 1},
//            {"unionToken", ""},//第三方唯一Token
//            {"unionType", ""},//登录方式：1-QQ，2-微博，3-微信，10-hwt充值卡
//            {"nickname", ""},
//            {"unionContent", ""},
//            {"unionAvatar", ""},
            {"loginType", 1},//1-手机号登录，2-第三方登录

    };

    Object[][] thirdLoginString = {//key-- value
            {"telephone", ""},
            {"password", ""},
            {"vcode", ""},
            {"unionToken", "4B5296AE2318F4E9CDFF1DEDA748F823"},//第三方唯一Token
            {"unionType", "1"},//登录方式：1-QQ，2-微博，3-微信，10-hwt充值卡
            {"nickname", "w"},
            {"unionContent", ""},
            {"unionAvatar", "http://q.qlogo.cn/qqapp/1106564086/B65AC6BF436FC01566A2318789375255/100"},
            {"loginType", 2},//1-手机号登录，2-第三方登录

    };


    Object[][] getNesestString = {//key-- value
            {"platformType", "1"},
    };


    String loginDebug = "/user/anno/loginBasic";

    String getNewestDebug = "/clientversion/getnewest";//获取最新版本


    String debugCheckMobile = "/user/anno/checkReg";//判断手机是否被注册
    String debugCheckTel = "/user/anno/checkTel";//第三方绑定手机号时，判断手机号是否被绑定过

    int index = 2;
//    String url = getFieldValue(clazz) + getPostValue(index, clazz);


    Object[][] string = {//key--value
            {"telephone", "15381042981"},
    };

    Object[][] checkTelString = {//key--value
            {"telephone", "121212"},
            {"unionType", "1"},
    };

    @Test
    public void testCheckTel() {
        HttpUserGetTest.get(checkTelString, debugCheckTel);
    }


    /**
     * 获取用户信息
     */
    @Test
    public void testGetUserInfo() {
        HttpUserGetTest.get(new Object[][]{//key--value
//                {"telephone", "18966161014"},

        }, "/user/getUserInfo");
    }


    @Test
    public void testCheckPhone() {
        HttpUserGetTest.get(string, debugCheckMobile);
    }

    @Test
    public void relieveBindEscrowAccount() {
        HttpBaseApplicationJson.postFormByApplicationJson(new Object[][]{{"userEscrowAccountId", "11"},}, "/user/relieveBindEscrowAccount");
    }

    @Test
    public void testNoReadMessageAndCoup() {
        HttpBaseApplicationJson.postFormByApplicationJson(new Object[][]{}, "/user/getNoReadMessageAndCoup");
    }


    @Test
    public void testNewest() {
        HttpGetFormTest.get(getNesestString, getNewestDebug);

    }

    @Test
    public void checkPayPassword() {
        HttpGetFormTest.get(new Object[][]{
                {"telephone","13634133426"}
        }, "/user/checkPayPassword");

    }


    @Test
    public void password() {
        HttpBaseApplicationJson.postFormByApplicationJson(new Object[][]{//key-- value
                {"telephone", "13434133426"},
                {"password", "12345678"},
                {"vcode", "123321"},
                {"handleType", 7},

        }, "/user/anno/lost-password");

    }

    @Test
    public void testRegister() {
        HttpBaseApplicationJson.postFormByApplicationJson(new Object[][]{//key-- value
                {"telephone", "13434133421"},
                {"password", "123321212"},
                {"regChannel", "1"},
                {"vcode", "123321"},
                {"handleType", 1},

        }, "/user/anno/register");
    }

    @Test
    public void testLogin() {
        HttpBaseApplicationJson.postFormByApplicationJson(thirdLoginString, loginDebug);
    }

    Object[][] collectStringString = {//key-- value
            {"chargingStationId", "1"},
    };

    /**
     * 判断充电站是否被收藏过
     */
    @Test
    public void checkCollect() {
        HttpUserGetTest.get(new Object[][]{{"chargingStationId", "2"}}, "/user-collect/checkCollect");
    }

    @Test
    public void testCollectStation() {
        HttpBaseApplicationJson.postFormByApplicationJson(new Object[][]{{"chargingStationId", "2"}}, "/user-collect/insert");
    }

    @Test
    public void testUnCollectStation() {
        HttpBaseApplicationJson.postFormByApplicationJson(collectStringString, "/user-collect/delete");
    }

}
