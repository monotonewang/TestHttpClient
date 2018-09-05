package com.example.ubuntu.testhttpclient.http.funki;

import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

public class HttpFunkiFormsTest {


    //    Class clazz = UserApi.class;
    int index = 2;
//    String url = getFieldValue(clazz) + getPostValue(index, clazz);


    Object[][] string = {//key--value
            {"userId", 1},
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
//            {"orderId", "422"},
//            {"ownerId", "422"},
//            {"paymentId", "PAY-68E23130TJ730012RLF5Q5PQ"},
//            {"blogId", "5983e847455f4a1f2ea88c4f"},
//            {"commentId", "59798f7b455f4a01f91fb551"},
//            {"topic", "#xxxx#"},
//            {"paymentId", "PAY-66A268946H070260PLGCFYEY"},
//            {"relationType", 2},	//1:拉黑的好友， 2：好友， 3：关注的用户， 4：粉丝
//            {"text", "xx"},
//            {"textB", "xx"},
//            {"blogId", "597196eb6c934f69a6214b84"},
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
            {"size", 11},
//            {"pageSize", 10},
//            {"page", 1},
//            {"perPage", 11},
//            {"productId", "2"},
//            {"ledgerType", 5},
//            {"ledger", 5},//(0,总流水账单;1,充值账单;2,消费账单;3,收入账单;4,兑换账单;5,提现账单)
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
//            {"roomId", 12},
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
//            {"district", "xx"},
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

    //blog
//String url = "http://app.hifunki.com/dev_blogstream/blog/comment/send";//评论动态消息
//String url = "http://app.hifunki.com/dev_blogstream/blog/userInfo/share";//分享个人名片到动态
    String url = "http://app.hifunki.com/dev_microblog/api/readNewBlogs";//读取最新动态
//String url = "http://35.164.1.183:7000/blogstream/blog/comment/praise";//评论点赞
//String url = "http://35.164.1.183:7000/blogstream/blog/comment/praise/cancel";//取消评论点赞
//String url = "http://35.164.1.183:7000/microblog/api/getBlogListByTopic";//读取话题动态
//String url = "http://35.164.1.183:7000/blogstream/blog/delete";//删除动态
//String url = "http://app.hifunki.com/dev_microblog/api/readMyBlogs";//读取我的动态
//String url = "http://35.164.1.183:7000/blogstream/blog/praise";//动态点赞
//String url = "http://35.164.1.183:7000/blogstream/blog/praise/cancel";//取消动态点赞
//String url = "http://35.164.1.183:7000/microblog/api/readFriendsBlogs";//读取关注人的动态
//String url = "http://app.hifunki.com/dev_microblog/api/getShareList";//获取转发列表
//String url = "http://app.hifunki.com/dev_microblog/api/getCommentList";//获取评论列表
//String url = "http://app.hifunki.com/dev_microblog/api/getBlogPraiseList";//获取点赞列表
//String url = "http://app.hifunki.com/dev_microblog/api/getReplyCommentList";//获取回复评论列表
//String url = "http://app.hifunki.com/dev_microblog/api/getBlogPraiseCount,";//获取动态的点赞数
//String url = "http://app.hifunki.com/dev_microblog/api/getMyBlogCount";//获取我的动态总数
//String url = "http://app.hifunki.com/dev_search-outputer/microblog/microblog";//动态搜索接口
//String url = "http://app.hifunki.com/dev_microblog/api/getBlogInfo";//批量读取动态详情

//auth
//String url = "http://app.hifunki.com/dev_auth/user/seal/cancel";//解封处理
//String url = "http://app.hifunki.com/dev_auth/user/feng/cancel";//时效性解封处理
//String url = "http://app.hifunki.com/dev_auth/login/byEmail";//邮箱登录
//String url = "http://app.hifunki.com/dev_auth/register/username/add";//添加用户名
//String url = "http://35.164.1.183:7000/auth/register/byEmail";//邮箱注册
//String url = "http://35.164.1.183:7000/auth/login/userInfo/get";//隐私与安全获取用户信息
//String url = "http://35.164.1.183:7000/auth/login/out";//退出
//String url = "http://35.164.1.183:7000/auth/login/password/check";//使用userId,校验密码
//String url = "http://35.164.1.183:7000/auth/register/getEmailCode";//获取邮箱验证码
//String url = "http://35.164.1.183:7000/auth/register/email/check";//校验邮箱验证码

    // user

//String url = "http://35.164.1.183:7000/user/user/tags/get";//获取个人标签
//String url = "http://35.164.1.183:7000/user/user/personalInfo/languages/get";//获取语言列表
//String url = "http://app.hifunki.com/dev_user/user/personalInfo/get";//获取用户编辑个人资料
//String url = "http://35.164.1.183:7000/user/user/asset/paypalAccount/set";//设置paypal账号
//String url = "http://app.hifunki.com/dev_user/user/album/get";//1. 个人相册图片获取
//String url = "http://app.hifunki.com/dev_user/user/album/get";//获取所有的私密相册
//String url = "http://35.164.1.183:7000/user/user/secretAlbum/get";//获取所有的私密相册
//String url = "http://35.164.1.183:7000/user/user/secretAlbum/upload ";//私密相册上传
//String url = "http://app.hifunki.com/dev_user/user/indexInfo/get";//用户个人中心信息请求
//String url = "http://35.164.1.183:7000/user/user/info/save";//用户保存信息
//String url = "http://app.hifunki.com/dev_user/user/secretAlbum/permissionLog/get";//私密相册权限记录查看
//String url = "http://app.hifunki.com/dev_user/user/album/delete";//4. 个人相册图片删除
//String url = "http://app.hifunki.com/dev_user/user/otherIndexInfo/get";//其他用户个人中心信息请求
//String url = "http://app.hifunki.com/dev_user/user/secretAlbum/permission/apply";//私密相册权限申请
//String url = "http://app.hifunki.com/dev_user/user/visitLog/get";//来访记录
//    String url="http://app.hifunki.com/dev_user/user/personalInfo/languages/get";//11. 用户个人资料语言列表获取
//    String url="http://app.hifunki.com/dev_user/user/tags/get";//12. 标签信息获取
//String url = "http://app.hifunki.com/dev_user/user/diamondChargeInfo/get";//钻石充值页面
//String url = "http://app.hifunki.com/dev_user/user/vipBuyInfo/get";//VIP购买页面
//String url = "http://app.hifunki.com/dev_user/user/asset/gold/toCash";//金币兑现
//String url = "https://788f270wgg.execute-api.us-west-2.amazonaws.com/dev_user/user/vip/thirdPartBuyVipOrder/create";//创建第三方支付购买vip的订单
//String url = "http://app.hifunki.com/dev_user/user/asset/paymentPwd/set";//支付密码设置
//String url = "http://35.164.1.183:7000/user/user/accessLog/get";//访问记录查看
//String url = "http://app.hifunki.com/dev_user/user/asset/diamond/cashCharge";//使用余额充值钻石
//String url = "http://35.164.1.183:7000/user/user/asset/paymentPwd/check";//验证支付密码
//String url = "http://app.hifunki.com/dev_user/user/asset/ledgers/get";//流水账单
//String url = "http://35.164.1.183:7000/user/user/asset/diamond/thirdPartChargeOrder/create";//创建三方订单
//String url = "http://app.hifunki.com/dev_user/user/asset/diamond/paypalChargeOrder/check";//验证第三方充值钻石的订单
//String url = "http://app.hifunki.com/dev_user/user/vip/paypalBuyVipOrder/check";//验证paypal购买vip的订单
//String url = "http://app.hifunki.com/dev_user/user/asset/gold/toCashInfo/get";//金币兑换页面
//String url = "http://app.hifunki.com/dev_user/user/asset/paypalAccount/set";//paypal账户第一次设置
//    String url = "http://app.hifunki.com/dev_user/user/asset/cash/withdraw";// 提现
//    String url = "http://app.hifunki.com/dev_user/user/asset/monthLedgers/get";// 月账单
//    String url = "http://app.hifunki.com/dev_user/user/icon/video/save";//保存视频


//private-message
//String url="http://35.164.1.183:7000/im/im/attention/deal";//关注好友
//String url = "http://app.hifunki.com/dev_im/im/relation/list/detail/get";//2.获取与用户相应关系的用户相关信息
//String url="http://35.164.1.183:7000/im/im/relation/num/get";
//String url = "http://app.hifunki.com/dev_im/im/user/first/three/friend/get";//获取三个好友头像
//String url = "http://35.164.1.183:7000/im/im/defriend/or/cancel/deal";//拉黑或者取消拉黑好友
//String url = "http://35.164.1.183:7000/im/im/attention/cancel";//取消关注好友
//String url = "http://app.hifunki.com/dev_im/im/user/and/me/relation/get";//15.获取与某一用户的关系
//String url = "http://app.hifunki.com/dev_im/im/someone/relation/list/detail/get";//17.获取与某一用户相应关系的用户之间的相关信息
//String url = "http://app.hifunki.com/dev_im/im/all/user/fuzzy/search";//17.获取与某一用户相应关系的用户之间的相关信息


// livestream
//String url = "http://35.164.1.183:7000/livestream/api/hot";//获取热门直播
//String url = "http://35.164.1.183:7000/livestream/api/latest";//获取最新直播

//live
//String url = "http://app.hifunki.com/dev_live/live/anchor/live/times/get";//获取直播次数
//String url = "http://35.164.1.183:7000/live/live/range";//获取直播间单次排行榜
//String url = "http://35.164.1.183:7000/live/live/anchor/end/live/count";//获取直播结束的资料
//String url = "http://35.164.1.183:7000/live/live/anchor/detail/get";//获取主播详情
//String url = "http://app.hifunki.com/dev_live/live/anchor/history/live/detail/get";//获取主播历史直播记录详情
//String url = "http://35.164.1.183:7000/live/live/anchor/live/status/get";//获取主播是否禁播
//String url = "http://app.hifunki.com/dev_live/live/anchor/one/live/income/detail/get";//获取主播一场直播收入详请
//String url = "http://app.hifunki.com/dev_live/live/gift/config/get";//7.排行榜
//    String url = "http://app.hifunki.com/dev_live/live/range";//排行榜
//    String url = "http://app.hifunki.com/dev_live/live/one/live/audience/consume/detail/get";//排行榜

//operation
//String url = "http://app.hifunki.com/dev_operation/backend/banners/get";//获取banner
//String url = "http://app.hifunki.com/dev_operation/liveAnnounces/get";//获取直播公告
//String url = "http://app.hifunki.com/dev_operation/topics/get";//获取话题列表
//String url = "http://35.164.1.183:7000/operation/hotWords/get";//获取热词
//String url = "http://app.hifunki.com/dev_operation/H5/get";//get H5
//String url = "http://app.hifunki.com/dev_operation/backend/notificationSwitch/off";//1.关闭消息通知
//String url = "http://app.hifunki.com/dev_operation/backend/notificationSwitch/status";//3.消息通知开关状态
//String url = "http://app.hifunki.com/dev_operation/report/create";//举报
//String url = "http://app.hifunki.com/dev_operation/reportReasons/get";//举报列表
//String url = "http://app.hifunki.com/dev_operation/hotWords/get";//举报列表

//shop
//String url="http://app.hifunki.com/dev_shop/products/all";
//String url="http://app.hifunki.com/dev_shop/product/info";
//String url="http://app.hifunki.com/dev_shop/order/create/first";
//String url="http://app.hifunki.com/dev_shop/order/create/second";
//String url="http://app.hifunki.com/dev_shop/orders/all";//10.获取订单列表
//String url="http://app.hifunki.com/dev_shop/address/set_default";//5.设置默认收货地址
//String url="http://app.hifunki.com/dev_shop/address/update";//7.编辑收货地址

    @Test
    public void postFormByApplicationJson() {
        CloseableHttpClient httpclient = HttpClients.createDefault();// 创建默认的httpClient实例.
        System.out.println("url=" + url);
        HttpPost httppost = new HttpPost(url);        // 创建httppost
        httppost.addHeader("Content-type", "application/json; charset=utf-8");
//        httppost.addHeader("Content-type", "application/json");
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
                } else if (value instanceof Boolean) {
                    Boolean value2 = (Boolean) value;
                    j.addProperty(key, value2);
                }
            }
        }
        String string = j.toString();
        System.out.println("xxx=" + string);
        httppost.setEntity(new StringEntity(string, Charset.forName("UTF-8")));
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
