//package com.example.ubuntu.testhttpclient.weakreference;
//
//import org.junit.Test;
//
//import java.lang.ref.SoftReference;
//import java.lang.ref.WeakReference;
//
//public class TestWeakReference {
//
//    @Test
//    public void testStrong(){
//        People reference=new People("s",1);
//        System.out.println(reference);
//        long initm=Runtime.getRuntime().freeMemory();
//        System.out.println("initm="+initm);
//        reference=null;
////        reference.clear();
//        System.gc();
//        if(reference!=null) {
//            System.out.println(reference);
//        }
//        long end = Runtime.getRuntime().freeMemory();
//        System.out.println("end="+end);
//    }
//
//    @Test
//    public void testSoft(){
//        SoftReference<People> reference=new SoftReference<People>(new People("s",1));
//        long initm=Runtime.getRuntime().freeMemory();
//        System.out.println("initm="+initm);
//        System.out.println(reference.get());
////        reference.clear();
//        System.gc();
//        System.out.println(reference.get());
//        long end=Runtime.getRuntime().freeMemory();
//        System.out.println("end"+end);
//    }
//
//    @Test
//    public void testWeak(){
//        WeakReference<People> reference=new WeakReference<People>(new People("s",1));
//        System.out.println(reference.get());
//        long initm=Runtime.getRuntime().freeMemory()/1024/1024;
//        long totalMemory=Runtime.getRuntime().totalMemory()/1024/1024;
//        long maxMemory=Runtime.getRuntime().maxMemory()/1024/1024;
//        System.out.println("initm="+initm+"total"+totalMemory+"totalMemory"+"maxMemory="+maxMemory);
////        reference.clear();
//        System.gc();
//        System.out.println(reference.get());
//        long end=Runtime.getRuntime().freeMemory()/1024/1024;
//        long totalMemoryx=Runtime.getRuntime().totalMemory()/1024/1024;
//        long maxMemoryx=Runtime.getRuntime().maxMemory()/1024/1024;
//        System.out.println("end="+end+"total"+totalMemoryx+"totalMemoryx"+"maxMemoryx="+maxMemoryx);
//    }
//
//
//
//
//}
