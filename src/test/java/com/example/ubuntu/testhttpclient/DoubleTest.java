package com.example.ubuntu.testhttpclient;

import org.apache.http.util.TextUtils;
import org.junit.Test;

import java.text.DecimalFormat;

/**
 * Created by zgjxf on 2018/1/3.
 */

public class DoubleTest {


    //    }

    /**
     * 保留两位 为空则为0
     */
    @Test
    public void test() {
        String duration = "";
        String x = null;
        if (!TextUtils.isEmpty(x)) {
            if (!x.equals("0")) {
                try {
                    duration = new DecimalFormat("#0.00").format(Double.valueOf(x));
                } catch (Exception e) {
                    duration = "0";
                }
            }else{
                duration = "0";
            }
        } else {
            duration = "0";
        }

        System.out.println("dsds=" + duration);
    }

    @Test
    public void testDouble() {
        int a = 50;
        double b = a;

        double x = 0.0;
        if (x == 0d) {
            System.out.println("xxxxx");
        }
        //50.0

        Object ax = 1;
        if (ax instanceof Double) {
            System.out.println(ax);
        } else if (ax instanceof Integer) {
            System.out.println("int=" + ax);
        }

    }

    @Test
    public void testServerDouble(){
        double a=1.00;

        double b=a;

        System.out.println(b);
    }

    @Test
    public void testPluse() {
        int b = 5;
        ++b;
        System.out.println(b++);
    }

    @Test
    public void testTwo() {
        Double aDouble = Double.valueOf("0.00");
        if(aDouble<=0)
        System.out.println(aDouble);
//        double a = 0.0;
//        DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
////        System.out.println(decimalFormat.format(v));   //12
//
//        String power = "0.0";
//        String format = new DecimalFormat("###############################################################################################.##").format(Double.parseDouble(power));
//
//        System.out.println("format=" + format);
        double money = 1.;
        String format1 = new DecimalFormat("#0.00").format(money);

        System.out.println(format1);

    }


}
