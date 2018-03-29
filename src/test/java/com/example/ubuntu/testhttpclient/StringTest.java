package com.example.ubuntu.testhttpclient;

import org.apache.commons.codec.binary.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URI;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ubuntu on 17-8-31.
 */

public class StringTest {

    public class Student {
        String name;
        int id;
    }

    @Test
    public void testStringEmpty() {
        Student student = new Student();
        String name = student.name;
        if (name == null) {
            System.out.println("null");
        }
        if (name.length() > 0) {
            System.out.println("length is null");
        }
        System.out.println(name);
    }


    @Test
    public void testStringTwoEmpty() {
        String str = null;
        if (str == null) str = "1.2";
//        if (str.length()>0) str= "0";
        Double aDouble = Double.valueOf(str);
//        DecimalFormat df = new DecimalFormat("#0.00");
        DecimalFormat df = new DecimalFormat("#0");
        System.out.println(df.format(aDouble));
        System.out.println("---------------------");
    }

    @Test
    public void testContainString() {
        String test = "fdafasd fdev dsafasdfa";
        if (test.contains("dev")) {
            System.out.println("yes");
        }
    }

    @Test
    public void testStringJson() {
        String json = "{\"chargingPileId\":\"53\",\"chargingStationId\":\"29\",\"jpushType\":\"250\",\"chargingId\":\"82\",\"extendField\":\"2\"}";

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);


            long extendFieldX = jsonObject.getLong("extendField");
            long chargingId = jsonObject.getLong("chargingId");
            long chargingPileId = jsonObject.getLong("chargingPileId");
            long chargingStationId = jsonObject.getLong("chargingStationId");

            System.out.println("--------------" + "s_alert_cancel_appoint extendFieldX=" + extendFieldX + "chargingId=" + chargingId + "chargingPileId=" + chargingPileId);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testString() {

        BigDecimal bigDecimal = new BigDecimal(0.1);
        String string1 = bigDecimal.toString();
        System.out.println(string1);

//        long string = 19;
//        String format = String.format("%02l", string);
//        System.out.println(format);

    }

    @Test
    public void testXX() {
        String host = "aaa";
        if (!host.startsWith("api.weibo.com") || !host.startsWith("api.weixin.qq.com")) {
            System.out.println("xxxxxxxxxxx");
        } else {
            System.out.println("yyyyyyyyyyyyyy");
        }
    }

    @Test
    public void testSplitCity() {

        String city = "杭州市";
        String substring = city.substring(0, city.length() - 1);
        System.out.println(substring);

    }


    @Test
    public void testReplace() {
        String a = "2";
//        String
        String replace = a.replace(a, "22121212");
        System.out.println(replace);
    }

    @Test
    public void testUriPath() {
        String mBaseUrlAndVersion = "https://api.hifunki.com/v_1_0/microblog/api/readNewBlogs";
        URI uri = URI.create(mBaseUrlAndVersion);
        String host = uri.getHost();
        String path = uri.getPath();
        String scheme = uri.getScheme();
        System.out.println("host=" + host + "scheme=" + scheme + "path=" + path);

    }

    @Test
    public void testUnicode() throws UnsupportedEncodingException {
        String temp = "The withdraw amount shall be in between \\u20ac 50 and \\u20ac 500.You can only withdraw once per day.";
        String s = new String(temp.getBytes(), "UTF-8");
        System.out.println(s);
    }

    @Test
    public void testStringFormat() {
//        String string = "Qty: %1$s count Cost：€%2$s";
//        String string1 = "Qty: %s count Cost：€ %s";
//        String vipdays = "VIP %s days";
//
//        String format = String.format(vipdays, "1");
//
//        System.out.println(format);
////<string name="aa" formatted="false">Qty: %s count Cost：€ %s</string>
//
//        String result = String.format(string1, "xxx", "yyyy");
//
//
//        System.out.println(result);

        double a = 130.0;
        double floor = Math.floor(a);
        System.out.println(floor);
        String s = decimalFormat0(a);
        getMinToHours(s);
    }

    public void getMinToHours(String a) {
        if (Integer.valueOf(a) >= 60) {
            int i = Integer.valueOf(a) / 60;
            int i1 = Integer.valueOf(a) % 60;

            System.out.println(i + "小时" + i1 + "分钟");
        } else {
            System.out.println(a + "分钟");
        }
    }


    @Test
    public void intGetZero() {
        int ss = 1;
        if (ss > 99) {
            String substring = String.valueOf(ss).substring(0, 2);
            System.out.println(substring);
        }

        if (ss < 10) {

            String substring = String.valueOf(ss) + "0";

            System.out.println("xxxxxxx" + substring);
        }

    }

    public static String decimalFormat0Left0(double floor) {
        return new DecimalFormat("#0").format(floor);
    }

    @Test
    public void test() {
        String secondTOHMS = getSecondTOHMS(61);
        System.out.println(secondTOHMS);
    }

    public String getSecondTOHMS(double SecondT) {
        if (SecondT < 0) return "0秒";
        if (SecondT < 60) {
            return decimalFormat0Left0(SecondT) + "秒";
        }

        double floor = Math.floor(SecondT);

        String secondString = decimalFormat0Left0(floor);

        System.out.println(secondString);

        if (Integer.valueOf(secondString) >= 3600) {//是否大于一小时
            int i = Integer.valueOf(secondString) / 3600;
            int i1 = Integer.valueOf(secondString) / 60 % 60;
            int i2 = Integer.valueOf(secondString) / 3600 % 3600;

            System.out.println("xxxxxx====" + i + "-----i1=" + i1);

            if (i != 0) {
                if (i1 != 0) {
                    return i + "时" + i1 + "分" + i2 + "秒";
                } else {
                    return i + "时" + i2 + "秒";
                }
            } else {
                return i + "时";
            }
        } else {

            int i1 = Integer.valueOf(secondString) / 60;
            int i2 = Integer.valueOf(secondString) % 60;
            if (i1 != 0) {
                if (i2 != 0) {
                    return i1 + "分" + i2 + "秒";
                } else {
                    return i1 + "分";
                }
            } else {
                return i1 + "分";
            }
        }
    }

    /**
     * 没有小数点后面的数字
     *
     * @param money
     * @return
     */
    public String decimalFormat0(double money) {
        return new DecimalFormat("###################.###########").format(money);
    }

    @Test
    public void testSplit() {
//        String image="open_screen_title_img_1357.png";
//        int i = image.lastIndexOf(".");
//        System.out.println(i);
//        String substring = image.substring(i+1, image.length());
//        System.out.println(substring);

        String image = "12:02:03";
        String i = image.substring(0, 5);
        System.out.println(i + "length=" + i.length());
    }

    @Test
    public void testSplitEqual() {
        String result = "/charging/scanCharging?chargingPileId=512&chargingId=22";
        String frameNo = result.substring(result.indexOf("=") + 1, result.lastIndexOf("&"));
        String frameNo2 = result.substring(result.lastIndexOf("=") + 1, result.length());
        System.out.println(frameNo);
        System.out.println(frameNo2);
    }




    @Test
    public void testHWT() {
        String url = "http://api-hwt.haoxitech.com/app/pages/detail.php?target=charger&app=fengchao&charger_id=4484&pile_no=EN10703171170576&charger_no=1&category=3";

        if (url.startsWith("http://api-hwt.haoxitech.com/app/pages/detail.php")) {
            if (!url.substring(url.length() - 1, url.length()).equals("&")) {
                url=url+"&";
            }
            System.out.println("url="+url);
            if (url.contains("pile_no") && url.contains("charger_no") && url.contains("category")) {

                int i = url.indexOf("pile_no");
                int j = url.indexOf("charger_no");
                int k = url.indexOf("category");

                if (i != -1 && j != -1 && k != -1) {
                    LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
                    linkedHashMap.put(k, "category");
                    linkedHashMap.put(i, "pile_no");
                    linkedHashMap.put(j, "charger_no");

                    //遍历输出
                    for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                    }

                    System.out.println("i=" + i + "j=" + j + "k=" + k);


                    //先转成ArrayList集合
                    ArrayList<Map.Entry<Integer, String>> list =
                            new ArrayList<Map.Entry<Integer, String>>(linkedHashMap.entrySet());

                    //从小到大排序（从大到小将o1与o2交换即可）
                    Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {

                        @Override
                        public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                            return ((o1.getKey() - o2.getKey() == 0) ? 0 : (o1.getKey() - o2.getKey() > 0) ? 1 : -1);
                        }

                    });

                    //新建一个LinkedHashMap，把排序后的List放入
                    LinkedHashMap<Integer, String> newLinkedHashMap = new LinkedHashMap<>();
                    for (Map.Entry<Integer, String> entry : list) {
                        newLinkedHashMap.put(entry.getKey(), entry.getValue());
                    }

                    //遍历输出
                    for (Map.Entry<Integer, String> entry : newLinkedHashMap.entrySet()) {
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                    }

                    char at = '&';

                    System.out.println("------------------------------");

                    for (Map.Entry<Integer, String> entry : newLinkedHashMap.entrySet()) {

                        Integer key = entry.getKey();
                        for (int t = key; t < url.length(); t++) {
                            if (url.charAt(t) == at) {
                                int keyStartIndex = key + entry.getValue().length() + 1;

                                System.out.println("keyStartIndex=" + keyStartIndex + "t=" + t);
                                String substring = url.substring(keyStartIndex, t);

                                newLinkedHashMap.put(key,"testabc"+entry.getValue());

                                System.out.println(substring);
                                break;
                            }
                        }
                    }

                    //遍历输出
                    for (Map.Entry<Integer, String> entry : newLinkedHashMap.entrySet()) {
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                    }
                }


            } else {
                System.out.println("not found error");
            }
        } else {
            System.out.println("not found");
        }

    }

}
