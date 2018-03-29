package com.example.ubuntu.testhttpclient;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class TestTimeUtils {

    @Test
    public void testTimeFormat(){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        System.out.println(time);
    }
//1513161633167
    @Test
    public void testTimeFormats(){
        long longx = System.currentTimeMillis();
        System.out.println(longx);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(longx);
        System.out.println(format);
    }

    @Test
    public void testYYtoString(){
//        1513162802078
        Date dt = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            dt = dateFormat.parse("2017-12-13 19:00:02");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = dt.getTime();
        System.out.println(time);
        long l = time + TimeZone.getDefault().getRawOffset();
        System.out.println(l);
    }

    public static String decimalFormat0Left2(Double money) {
        if (money==null){
            money=0.0;
        }
        return new DecimalFormat("###################.##").format(money);
    }

    public static String decimalFormat0Left0(Double floor) {
        if (floor==null){
            floor=0.0;
        }
        return new DecimalFormat("#0").format(floor);
    }

    @Test
    public void testTime(){
        String s = testTimeTOHourMinutesAndSeconds();
        System.out.println(s);
    }

    public String testTimeTOHourMinutesAndSeconds(){


        double SecondT=3661.03;

        if (SecondT < 0) return "0秒";
        if (SecondT < 60) {
            return decimalFormat0Left0(SecondT) + "秒";
        }

        double floor = Math.floor(SecondT);

        String secondString = decimalFormat0Left0(floor);

        System.out.println(secondString);

        if (Integer.valueOf(secondString) >= 3600) {//是否大于一小时
            int i = Integer.valueOf(secondString) / 3600;
            int i1 = Integer.valueOf(secondString)/60 % 60;
            int i2 = Integer.valueOf(secondString) / 3600%3600;

            System.out.println("xxxxxx===="+i+"-----i1="+i1);

            if (i != 0) {
                if(i1!=0) {
                    return i + "时" + i1 + "分" + i2 + "秒";
                }else{
                    return i + "时" + i2 + "秒";
                }
            } else {
                return i + "时";
            }
        } else {

            int i1 = Integer.valueOf(secondString) / 60;
            int i2 = Integer.valueOf(secondString) % 60;
            if (i1 != 0) {
                return  i1 + "分"+i2+"秒";
            } else {
                return i1 + "分";
            }
        }
    }
}
