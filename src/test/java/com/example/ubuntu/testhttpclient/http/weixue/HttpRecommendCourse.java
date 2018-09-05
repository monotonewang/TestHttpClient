package com.example.ubuntu.testhttpclient.http.weixue;

import com.example.ubuntu.testhttpclient.http.HttpGetFormTestx;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HttpRecommendCourse {


    /**
     * 推荐课程排序
     */
    @Test
    public void sortRecommendList() {

        List<String> recommendListX = getRecommendListX();

        System.out.println("recommendListX=" + recommendListX);
        Collections.swap(recommendListX, 0, 1);

        System.out.println("recommendListX after--sort=" + recommendListX);
        HashMap hashMapCompany = new HashMap<>();
        hashMapCompany.put("token", HttpWeixueTest.getToken());
        hashMapCompany.put("organization_id", HttpWeixueTest.getOrganization_id(0));
        for (int i = 0; i < recommendListX.size(); i++) {

            hashMapCompany.put(String.format("course_id[%s]", i), recommendListX.get(i));
        }
//            hashMapCompany.put(String.format("course_id[%s]", 0),"2228");
//            hashMapCompany.put(String.format("course_id[%s]", 1),"2258");

        JsonObject jsonObjectCompany = HttpGetFormTestx.getFormString(hashMapCompany, HttpWeixueTest.getBaseUrl(HttpWeixueTest.http_status) + "/v1/organization/recommend_course/update_all_sort");
        //getNewCourseId
        System.out.println(jsonObjectCompany);

        List<String> recommendListY= getRecommendListX();

        System.out.println("recommendListX after--server sort=" + recommendListY);
    }


    @Test
    public void getRecommendList() {

        HashMap hashMapCompany = new HashMap<>();
        hashMapCompany.put("token", HttpWeixueTest.getToken());
        hashMapCompany.put("organization_id", HttpWeixueTest.getOrganization_id(0));

        JsonObject jsonObjectCompany = HttpGetFormTestx.getFormString(hashMapCompany, HttpWeixueTest.getBaseUrl(HttpWeixueTest.http_status) + "/v1/organization/recommend_course/list");
        //getNewCourseId
        JsonArray data = jsonObjectCompany.getAsJsonArray("data");
        if(data!=null) {
            List<String> list = new ArrayList<>();
            for (JsonElement jsonElement : data) {
                String course_id = jsonElement.getAsJsonObject().get("course_id").getAsString();
                list.add(course_id);
            }
            System.out.println(list);
        }

    }




    public List<String> getRecommendListX() {

        HashMap hashMapCompany = new HashMap<>();
        hashMapCompany.put("token", HttpWeixueTest.getToken());
        hashMapCompany.put("organization_id", HttpWeixueTest.getOrganization_id(0));

        JsonObject jsonObjectCompany = HttpGetFormTestx.getFormString(hashMapCompany, HttpWeixueTest.getBaseUrl(HttpWeixueTest.http_status) + "/v1/organization/recommend_course/list");
        //getNewCourseId
        JsonArray data = jsonObjectCompany.getAsJsonArray("data");
        List<String> list = new ArrayList<>();
        for (JsonElement jsonElement : data) {
            String course_id = jsonElement.getAsJsonObject().get("course_id").getAsString();
            list.add(course_id);
        }
        return list;
    }

}
