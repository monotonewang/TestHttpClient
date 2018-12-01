package com.example.ubuntu.testhttpclient.http.cunshu;

import com.example.ubuntu.testhttpclient.http.HttpGetFormTestx;
import com.example.ubuntu.testhttpclient.http.weixue.HttpWeixueTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HttpManageCondition {


    @Test
    public void getRecommendList() {

        HashMap hashMapCompany = new HashMap<>();
        hashMapCompany.put("token", HttpCunshuTest.getToken());
        hashMapCompany.put("village_id", HttpCunshuTest.getVillage_id());
        hashMapCompany.put("type_id", "10");
        hashMapCompany.put("viewed", "1");
        hashMapCompany.put("per_page", "10");

        JsonObject jsonObjectCompany = HttpGetFormTestx.getFormString(hashMapCompany, HttpCunshuTest.getBaseUrl(HttpCunshuTest.http_status) + "/v1/village/notice/family/index");
        //getNewCourseId
        JsonArray data = jsonObjectCompany.getAsJsonArray("data");
        if (data != null) {
            List<String> list = new ArrayList<>();
            for (JsonElement jsonElement : data) {
                String course_id = jsonElement.getAsJsonObject().get("course_id").getAsString();
                list.add(course_id);
            }
            System.out.println(list);
        }

    }

}
