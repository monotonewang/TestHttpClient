package com.example.ubuntu.testhttpclient.timetest;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by Administrator on 2017/12/15 0015.
 */

/**
 * java演示倒计时
 */
public class TestTime {


    public static int time = 60 * 60 * 60;
    public static Calendar c;
    public static long endTime;
    public static Date date;
    public static long startTime;
    public static long midTime;

//2017-12-06 08:16:54
//---accept=aLong=-21endTime=1515576002000nowTimeL=1515576023757

    @Test
    public void testGetUserTime() {
        String time="2018-01-10 17:21:00";
        long l = DateUtil.parseLong(time);
        System.out.println(l);
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
        long l1 = currentTimeMillis - l;
        long l2 = l1 / (1000 * 60);
        System.out.println(l2);
        System.out.println(l1/1000);
    }

    @Test
    public void testGetLeftTime() {
        String time="2017-12-28 19:20:54";
        long l = DateUtil.parseLong(time);
        System.out.println(l);
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
        long l1 = currentTimeMillis - l;
        long l2 = -l1 / (1000 * 60);
        System.out.println(l2);
        System.out.println(l1);
    }

    @Test
    public void testTimess() {

        c = Calendar.getInstance();
        c.set(2018, 4, 17, 0, 0, 0);// 注意月份的设置，0-11表示1-12月
        // c.set(Calendar.YEAR, 2017);
        // c.set(Calendar.MONTH, 4);
        // c.set(Calendar.DAY_OF_MONTH, 17);
        // c.set(Calendar.HOUR_OF_DAY, 0);
        // c.set(Calendar.MINUTE, 0);
        // c.set(Calendar.SECOND, 0);

        endTime = c.getTimeInMillis();
        System.out.println(endTime);

        date = new Date();

        startTime = date.getTime();

        System.out.println(startTime);

        midTime = (endTime - startTime) / 1000;

        midTime = 30 * 60;

        System.out.println(midTime);
//             time1();//方式一
        time2();// 方式二
        // time3();//方式三
    }

    /**
     * 方式三： 使用java.util.Timer类进行倒计时
     */
    private static void time3() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                midTime--;
                long hh = midTime / 60 / 60 % 60;
                long mm = midTime / 60 % 60;
                long ss = midTime % 60;
                System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            }
        }, 0, 1000);
    }

    /**
     * 方式二： 设定时间戳，倒计时
     */
    private static void time2() {

        while (midTime > 0) {
            midTime--;
            long hh = midTime / 60 / 60 % 60;
            long mm = midTime / 60 % 60;
            long ss = midTime % 60;
            System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 方式一： 给定时长倒计时
     */
    private static void time1() {
        while (time > 0) {
            time--;
            try {
                Thread.sleep(1000);
                int hh = time / 60 / 60 % 60;
                int mm = time / 60 % 60;
                int ss = time % 60;
                System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
