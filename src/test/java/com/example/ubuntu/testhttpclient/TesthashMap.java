package com.example.ubuntu.testhttpclient;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/2/6 0006.
 */

public class TesthashMap {

    public static Map<String, String> markerMap = new ConcurrentHashMap<>();

    @Test
    public void testHashMap(){
        markerMap.put("a","b");
        markerMap.put("a","b3");

        System.out.println(markerMap.size());
    }
}
