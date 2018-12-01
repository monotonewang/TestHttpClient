package com.example.ubuntu.testhttpclient.http.cunshu;

import com.example.ubuntu.testhttpclient.http.HttpFormTest;
import com.example.ubuntu.testhttpclient.http.HttpGetFormTestx;
import com.example.ubuntu.testhttpclient.http.properties.PropertiesUtils;
import com.example.ubuntu.testhttpclient.http.weixue.HttpWeixueTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.util.TextUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HttpCunshuTest {
    //    https://test.eweixue.com/v1/organization/recommend_course/list?per_page=10&organization_id=Jb71kNvY&page=1&is_organization=1&version=1139&platform=android&token=yDtjJQ8fEdkQRFUY


    public enum HTTP_STATUS {
        test, release
    }

    //        public static HTTP_STATUS http_status = HTTP_STATUS.sxq;
    public static HttpWeixueTest.HTTP_STATUS http_status = HttpWeixueTest.HTTP_STATUS.test;

    public static String getBaseUrl(HttpWeixueTest.HTTP_STATUS http_status) {
        switch (http_status) {
            case test:
                return "https://test.gongtongti.com.cn";
            case release:
                return "https://api.eweixue.com";
            default:
                return "";
        }
    }



    static String organization_id = "organization_id";
    static  String token = "token";
    static  String customer_id = "customer_id";
    static  String village_id = "village_id";

    /**
     * @return
     */
    public static List<String> getTokenAndCustomerId() {

        String mobile = "13634133431";

        HashMap hashMap = new HashMap<>();

        hashMap.put("mobile", mobile);
        JsonObject formString = HttpGetFormTestx.getFormString(hashMap, getBaseUrl(http_status) + "/v1/customer/code/get_code");
        if (formString.get("code").getAsString().equals("200")) {

            HashMap hashMapX = new HashMap<>();

            hashMapX.put("platform", "android");
            hashMapX.put("mobile", mobile);
            hashMapX.put("code", "1234");
            hashMapX.put("password", "123456");
            JsonObject jsonObject = HttpFormTest.postFormByForm(hashMapX, getBaseUrl(http_status) + "/v1/customer/auth/login");

            JsonObject data = jsonObject.get("data").getAsJsonObject();
            String tokenValue = data.get(token).getAsString();
            String customer_idValue = data.get(customer_id).getAsString();
            JsonArray village_list = data.getAsJsonArray("village_list");
            String village_id_value=village_list.get(0).getAsJsonObject().get("village_id").getAsString();
            System.out.println("token=" + tokenValue + "customer_id=" + customer_idValue+"village_id_value="+village_id_value);

            List<String> list = new ArrayList<>();
            list.add(tokenValue);
            list.add(customer_idValue);
            PropertiesUtils.updateProperties(token, tokenValue);
            PropertiesUtils.updateProperties(customer_id, customer_idValue);
            PropertiesUtils.updateProperties(village_id, village_id_value);
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

    public static String getVillage_id() {
        return PropertiesUtils.getKeyValue(village_id);
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
