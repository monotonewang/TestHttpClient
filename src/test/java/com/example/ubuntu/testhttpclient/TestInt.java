package com.example.ubuntu.testhttpclient;

import org.junit.Test;

/**
 * Created by Administrator on 2018/1/23 0023.
 */

public class TestInt {

    @Test
    public void testDouble() {
        int a = 1;
        a++;
        //50.0
        System.out.println("----"+a);
    }

    @Test
    public void testDouble2() {
        int a = 1;
        ++a;
        System.out.println(a);
    }

}
