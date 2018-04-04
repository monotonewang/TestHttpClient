package com.example.ubuntu.testhttpclient.weakreference;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class TestWeakReference {

    @Test
    public void testWeak(){
        WeakReference<People> reference=new WeakReference<People>(new People("s",1));
        System.out.println(reference.get());
        System.gc();
        System.out.println(reference.get());
    }

    @Test
    public void testSoft(){
        SoftReference<People> reference=new SoftReference<People>(new People("s",1));
        System.out.println(reference.get());
        reference=null;
        System.gc();
        System.out.println(reference.get());
    }
}
