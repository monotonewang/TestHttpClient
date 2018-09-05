package com.example.ubuntu.testhttpclient.http.weixue;

import com.example.ubuntu.testhttpclient.http.HttpFormTest;
import com.example.ubuntu.testhttpclient.http.HttpGetFormTestx;
import com.example.ubuntu.testhttpclient.properties.PropertiesUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.util.TextUtils;
import org.junit.Test;

import java.util.*;

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



    static String organization_id = "organization_id";
    static  String token = "token";
    static  String customer_id = "customer_id";

    /**
     * @return
     */
    public static List<String> getTokenAndCustomerId() {


        String mobile = "13634133426";
        HashMap hashMap = new HashMap<>();

        hashMap.put("mobile", mobile);
        JsonObject formString = HttpGetFormTestx.getFormString(hashMap, getBaseUrl(http_status) + "/v1/user/auth/get_code");
        if (formString.get("code").getAsString().equals("200")) {

            HashMap hashMapX = new HashMap<>();

            hashMapX.put("mobile", mobile);
            hashMapX.put("code", "1234");
            hashMapX.put("password", "xxx");
            JsonObject jsonObject = HttpFormTest.postFormByForm(hashMapX, getBaseUrl(http_status) + "/v1/user/auth/login");

            JsonObject data = jsonObject.get("data").getAsJsonObject();
            String tokenValue = data.get(token).getAsString();
            String customer_idValue = data.get(customer_id).getAsString();
            System.out.println("token=" + tokenValue + "customer_id=" + customer_idValue);

            List<String> list = new ArrayList<>();
            list.add(tokenValue);
            list.add(customer_idValue);
            PropertiesUtils.updateProperties(token, tokenValue);
            PropertiesUtils.updateProperties(customer_id, customer_idValue);
            return list;
        }
        return null;
    }


    /**
     * 获取token,先读取本地
     *
     * @return
     */
    public static String getToken() {
        String keyValue = PropertiesUtils.getKeyValue(token);
        System.out.println(keyValue);
        if (TextUtils.isEmpty(keyValue)) {
            List<String> tokenAndCustomerId = getTokenAndCustomerId();
        }
        return PropertiesUtils.getKeyValue(token);
    }

    public String getCustomer_id() {
        return PropertiesUtils.getKeyValue(customer_id);
    }

    public static String getOrganization_id(int position) {
        String keyValue = PropertiesUtils.getKeyValue(organization_id);
        System.out.println(keyValue);
        if (TextUtils.isEmpty(keyValue)) {
            String tokenAndCustomerId = getOrganizationServerId(0);
        }
        return PropertiesUtils.getKeyValue(organization_id);
    }

    @Test
    public void test() {
        String token = getToken();
        System.out.println("token=" + token);
//        getTokenAndCustomerId();
    }


    /**
     * 获取服务器organizationId
     *
     * @param position
     * @return
     */
    public static String getOrganizationServerId(int position) {
        HashMap hashMapCompany = new HashMap<>();
        hashMapCompany.put("token", getToken());
        JsonObject jsonObjectCompany = HttpGetFormTestx.getFormString(hashMapCompany, getBaseUrl(http_status) + "/v1/user/info/organizations");
        System.out.println(jsonObjectCompany.toString());
        JsonArray data1 = jsonObjectCompany.getAsJsonArray("data");
        for (int i = 0; i < data1.size(); i++) {

            String organization_idValue = data1.get(i).getAsJsonObject().get("organization_id").getAsString();
            PropertiesUtils.updateProperties(organization_id, organization_idValue);
            return organization_idValue;
        }
        return "";

    }


    @Deprecated
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



}


