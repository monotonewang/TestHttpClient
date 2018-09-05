package com.example.ubuntu.testhttpclient.http.funki;

import com.google.gson.JsonObject;

import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.HashMap;


/**
 * 用于测试 application/x-www-form-urlencoded
 * Created by ubuntu on 17-7-11.
 */

public class HttpFormTest {

    int index = 2;
//    String url = getFieldValue(clazz) + getPostValue(index, clazz);


    Object[][] string = {//key--value
            {"userId", 107},
//            {"version", "1.0.1"},
//            {"text", "xxxx"},
//            {"searchWord", "擎天柱No1"},
//            {"reporterId", 21},
//            {"reportedId", 1},
//            {"reportedId", 1},
//            {"reportReasonId", 1},
//            {"description","x"},
//            {"video", "xxxx"},
//            {"month", "2017-07"},
//            {"keyword", "Funki"},
//            {"paypalAccount", "123"},
//            {"name", "xxxxxx"},
//            {"userIdB", 461},
//            {"title", "x"},
//            {"goldNum", 422},
//            {"orderId", 59},
//            {"token", "eyd0b2tlbl90eXBlJzogJ3JlZnJlc2gnLCAndHlwJzogJ0pXVCd9.eyJ1c2VyTmFtZSI6ICJoaHhnZm5jeGh4aHN4YnZiIiwgInN0YXR1cyI6IDAsICJtb2JpbGUiOiBudWxsLCAiZ2VuZGVyIjogMCwgImV4cGlyZXMiOiAxNTA2MzI0ODE3LjI4NTI2OCwgInVzZXJJZCI6IDEsICJzZnl6Zm1tIjogdHJ1ZSwgImltZWkiOiAiZmZmZmZmZmYtZjIzOC03YjllLTAwMDAtMDAwMDc1YjMxOWY4IiwgInVzZXJXb3JsZCI6ICIzYTI4NmY2MTAwOGYyNDFlIiwgInBheXBhbEFjY291bnQiOiAiMjkyMzU4NjUzQHFxLmNvbSIsICJuaWNrTmFtZSI6ICJTdW5zaGluZUJveSIsICJlbWFpbCI6ICIxQHFxLmNvbSIsICJ2aXBUeXBlIjogMSwgImljb24iOiAiaHR0cDovL2Nkbi5oaWZ1bmtpLmNvbS91c2VyL3BlcnNvbmFsX2RhdGEvQTAxLTE1MDMzOTkxNTMtMkU3NTJBRUItMkU3NC00OENGLUIwRUYtQ0MyMzgwNEE0Q0MyLnBuZyJ9.9ce25180c240af08f93471731cf2f5038c809adbbe015f6ddf484e84b51adc8f"},
//            {"ownerId", "422"},
//            {"paymentId", "PAY-6B936860CR369641RLGP3D3Y"},
//            {"blogId", "59a1250a455f4a689b42c620"},
//            {"commentId", "59798f7b455f4a01f91fb551"},
//            {"topic", "#xxxx#"},
//            {"paymentId", "PAY-66A268946H070260PLGCFYEY"},
//            {"relationType", 2},	//1:拉黑的好友， 2：好友， 3：关注的用户， 4：粉丝
//            {"text", "_ff6b4e9a_5"},
//            {"textB", "_ff6b4e9a_5"},
//            {"blogId", "59a13086455f4a68f3592a9b"},
//            {"district", 1},
//            {"attentionUser", 158},
//            {"cashNum", 2},
//            {"paymentPwd", "123456"},
//            {"anchorUserId", 281},//主播id
//            {"friendUserId", 206},//拉黑用户id
//            {"operateType", 1},//拉黑操作
//            {"ownerId", "411"},
//            {"requestUserId", "422"},
//            {"description", "xxxx"},
//            {"code", "xxx"},
//            {"tagType", "3"},
            {"index", 1},
            {"size", 50},
//            {"startTime", 112121},
//            {"endTime", 11121212},
//            {"sort", 0},
//            {"pageSize", 11},
//            {"page", 2},
//            {"perPage", 11},
//            {"productId", "2"},
//            {"ledgerType", 5},
//            {"ledger", 0},//(0,总流水账单;1,充值账单;2,消费账单;3,收入账单;4,兑换账单;5,提现账单)
//            {"rankType", 1},
//            {"rankKey", 21},

//            {"email", "0008@qq.com"},
//            {"password", "123456789"},
//            {"imei", "5x"},
//            {"arn", "xxx"},
//            {"code", "KeSbEs"},
//            {"paymentPwd", "123456"},
//            {"relationType", "5"},
//            {"paypalAccount", "007@qq.com"},
//            {"roomId", 327},
//            {"blackUserId", 206},
//            {"operateType", 1},
//            {"rankType", "1"},
//            {"ownerId", 422},
//            {"productId", "3"},
//            {"addressId", "53"},
//            {"address", "xxxxx"},
//            {"name", "xxxx"},
//            {"telephone", "xxxx"},
//            {"postcode", "xxxx"},
//            {"district", "_ff6b4e9a_5"},
//            {"is_default", false},
//            {"num", "1"},
//            {"orderSum", "20"},
//            {"invoice", "1"},
//            {"invoice", "1"},
//            {"message", "11"},
//            {"aimUserId", 422},
//            {"relationType", 3},//int	1:拉黑的好友， 2：好友， 3：关注的用户， 4：粉丝
//            {"page", 1},
//            {"size", 10},


//            {"token", "eyd0b2tlbl90eXBlJzogJ2FjY2VzcycsICd0eXAnOiAnSldUJ30=.eyJ1c2VyTmFtZSI6IG51bGwsICJzdGF0dXMiOiAwLCAibW9iaWxlIjogbnVsbCwgImdlbmRlciI6IDEsICJleHBpcmVzIjogMTUwMDAxMjM0MC4yNzMyODcsICJ1c2VySWQiOiAxNDEsICJzZnl6Zm1tIjogdHJ1ZSwgImltZWkiOiAiNXgiLCAicGF5cGFsQWNjb3VudCI6IG51bGwsICJuaWNrTmFtZSI6ICJiampqIiwgImVtYWlsIjogIjAwN0BxcS5jb20iLCAidmlwVHlwZSI6IDAsICJpY29uIjogIiJ9.8fb9e6ebbb244b3de650257bdafb05770109964d8af351fbe6d1acaaf1d98672"}


    };


//auth
//String url = "http://app.hifunki.com/dev_auth/background/user/seal/cancel";//解封处理
//String url = "http://app.hifunki.com/dev_auth/background/user/feng/cancel";//时效性解封处理
//String url = "http://app.hifunki.com/dev_auth/login/byEmail";//邮箱登录
//String url = "http://app.hifunki.com/dev_auth/register/username/add";//添加用户名
//String url = "http://35.164.1.183:7000/auth/register/byEmail";//邮箱注册
//String url = "http://35.164.1.183:7000/auth/login/userInfo/get";//隐私与安全获取用户信息
//String url = "http://35.164.1.183:7000/auth/login/out";//退出
//String url = "http://35.164.1.183:7000/auth/login/password/check";//使用userId,校验密码
//String url = "http://35.164.1.183:7000/auth/register/getEmailCode";//获取邮箱验证码
//String url = "http://35.164.1.183:7000/auth/register/email/check";//校验邮箱验证码







// livestream
//String url = "http://35.164.1.183:7000/livestream/api/hot";//获取热门直播
//String url = "http://35.164.1.183:7000/livestream/api/latest";//获取最新直播




    @Test
    public static JsonObject postFormByForm(HashMap<String,String> hashMap, String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();// 创建默认的httpClient实例.
        System.out.println("url=" + url);
        HttpPost httppost = new HttpPost(url);        // 创建httppost
        httppost.addHeader("Content-type", "application/json; charset=utf-8");

        httppost.addHeader("token", "eyd0b2tlbl90eXBlJzogJ2FjY2VzcycsICd0eXAnOiAnSldUJ30=.eyJ1c2VyTmFtZSI6ICIyRUVLOVo1SyIsICJzdGF0dXMiOiAwLCAibW9iaWxlIjogbnVsbCwgImdlbmRlciI6IDMsICJleHBpcmVzIjogMTUwNDE2MjA5NS42NjEwNzYsICJ1c2VySWQiOiAxMDcsICJzZnl6Zm1tIjogZmFsc2UsICJpbWVpIjogIjV4IiwgInVzZXJXb3JsZCI6ICJlOTA0MTJlNDExZDM5Y2I4IiwgInBheXBhbEFjY291bnQiOiBudWxsLCAibmlja05hbWUiOiAieGJ4aGRqZGpqIiwgImVtYWlsIjogIjEyNEBxcS5jb20iLCAidmlwVHlwZSI6IDAsICJpY29uIjogIiJ9.6cffe68f6beb5b650523cea1e4d0c01ae9dbc485d078135ecc52c7b2395c8e45");
        httppost.addHeader("funkiSystem", "androidFunki");
        httppost.addHeader("softwareName", "androidFunki8");
        httppost.addHeader("imei", "_ff6b4e9a_5");
        httppost.addHeader("session", "");
        httppost.addHeader("system", "Android5.0");
        httppost.addHeader("deviceName", "Mi-4C");
        httppost.addHeader("deviceType", "android8");
        httppost.addHeader("ip", "192.168.100.100");
        httppost.addHeader("geo", "");
        httppost.addHeader("isBreak", "1");
        httppost.addHeader("funkiVersion", "1");

        httppost.addHeader("Content-type", "application/json");
        httppost.setHeader("Accept", "application/json");
        JsonObject j = new JsonObject();


        for(String key:hashMap.keySet())
        {
            System.out.println("Key: "+key+" Value: "+hashMap.get(key));
            j.addProperty(key, hashMap.get(key));
        }

        String stringRes = j.toString();
        System.out.println("stringRes=" + stringRes);
        httppost.setEntity(new StringEntity(stringRes, Charset.forName("UTF-8")));
        try {
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("length" + entity.getContentLength());
                    String jsonString = EntityUtils.toString(entity, "UTF-8");
                    System.out.println();

                    JsonObject returnData = new JsonParser().parse(jsonString).getAsJsonObject();
                    return returnData;


//                    System.out.println("Response content: \n" + EntityUtils.toString(entity, "UTF-8"));
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }




    @Test
    public static void postFormByApplicationJson(Object[][] string, String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();// 创建默认的httpClient实例.
        System.out.println("url=" + url);
        HttpPost httppost = new HttpPost(url);        // 创建httppost
        httppost.addHeader("Content-type", "application/json; charset=utf-8");

        httppost.addHeader("token", "eyd0b2tlbl90eXBlJzogJ2FjY2VzcycsICd0eXAnOiAnSldUJ30=.eyJ1c2VyTmFtZSI6ICIyRUVLOVo1SyIsICJzdGF0dXMiOiAwLCAibW9iaWxlIjogbnVsbCwgImdlbmRlciI6IDMsICJleHBpcmVzIjogMTUwNDE2MjA5NS42NjEwNzYsICJ1c2VySWQiOiAxMDcsICJzZnl6Zm1tIjogZmFsc2UsICJpbWVpIjogIjV4IiwgInVzZXJXb3JsZCI6ICJlOTA0MTJlNDExZDM5Y2I4IiwgInBheXBhbEFjY291bnQiOiBudWxsLCAibmlja05hbWUiOiAieGJ4aGRqZGpqIiwgImVtYWlsIjogIjEyNEBxcS5jb20iLCAidmlwVHlwZSI6IDAsICJpY29uIjogIiJ9.6cffe68f6beb5b650523cea1e4d0c01ae9dbc485d078135ecc52c7b2395c8e45");
        httppost.addHeader("funkiSystem", "androidFunki");
        httppost.addHeader("softwareName", "androidFunki8");
        httppost.addHeader("imei", "_ff6b4e9a_5");
        httppost.addHeader("session", "");
        httppost.addHeader("system", "Android5.0");
        httppost.addHeader("deviceName", "Mi-4C");
        httppost.addHeader("deviceType", "android8");
        httppost.addHeader("ip", "192.168.100.100");
        httppost.addHeader("geo", "");
        httppost.addHeader("isBreak", "1");
        httppost.addHeader("funkiVersion", "1");

        httppost.addHeader("Content-type", "application/json");
        httppost.setHeader("Accept", "application/json");
        JsonObject j = new JsonObject();
        for (int x = 0; x < string.length; x++) {
            for (int y = 0; y < string[x].length; y++) {
                String key = (String) string[x][0];
                Object value = string[x][1];
                if (value instanceof String) {
                    String value1 = (String) value;
                    j.addProperty(key, value1);
                } else if (value instanceof Integer) {
                    Integer value1 = (Integer) value;
                    j.addProperty(key, value1);
                }else if (value instanceof Boolean) {
                    Boolean value2 = (Boolean) value;
                    j.addProperty(key, value2);
                }
            }
        }
        String stringRes = j.toString();
        System.out.println("stringRes=" + stringRes);
        httppost.setEntity(new StringEntity(stringRes, Charset.forName("UTF-8")));
        try {
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("length" + entity.getContentLength());
                    System.out.println(EntityUtils.toString(entity, "UTF-8"));
//                    System.out.println("Response content: \n" + EntityUtils.toString(entity, "UTF-8"));
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取类属性的value
     *
     * @param tClass
     * @param <T>
     * @return
     */
//    public <T> String getFieldValue(Class<T> tClass) {
//        Class<UserApi> clazz = UserApi.class;
//
//        Field[] fieldsx = clazz.getDeclaredFields();
//        for (Field field : fieldsx) {
//            System.out.println(field.getName());
//            field.setAccessible(true);
//            try {
//                String anInt = (String) field.get(null);
//                return anInt;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return "";
//    }

    /**
     * 获取Retrofit前面的url
     *
     * @param index
     * @param clazz
     * @return
     * @throws NoSuchMethodException
     */
//    public String getPostValue(int index, Class clazz) {
//        Method[] declaredMethods = clazz.getDeclaredMethods();
//        System.out.println(declaredMethods.length);
//        Annotation[] declaredAnnotations = declaredMethods[index].getDeclaredAnnotations();
//        String xx = "";
//        for (int k = 0; k < declaredAnnotations.length; k++) {
//            for (Annotation annotation : declaredAnnotations) {
//                if (annotation instanceof POST) {
//                    POST param = (POST) annotation;
//                    xx = param.value();
//                }
//            }
//        }
//        return xx;
//    }
}
