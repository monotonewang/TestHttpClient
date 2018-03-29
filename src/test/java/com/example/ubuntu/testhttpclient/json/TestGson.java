package com.example.ubuntu.testhttpclient.json;


import com.google.gson.Gson;
import org.junit.Test;

/**
 * Created by Administrator on 2018/2/8 0008.
 */

public class TestGson {

    @Test
    public void testGson(){
        String string="{\"code\":90005,\"message\":\"访问被拒绝\",\"data\":null}";
        Object o = new Gson().fromJson(string,String.class);

        System.out.println(o.toString());
    }
}
