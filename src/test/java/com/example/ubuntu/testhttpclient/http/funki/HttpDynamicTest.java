package com.example.ubuntu.testhttpclient.http.funki;



import com.example.ubuntu.testhttpclient.http.base.HttpBaseApplicationJson;

import org.junit.Test;

/**
 * Created by ubuntu on 17-9-1.
 */

public class HttpDynamicTest {



    Object[][] string = {//key--value
            {"userId", 38},
//            {"userId", 126},
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
            {"blogId", "59ea1283455f4a567157455b"},
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
            {"size", 10},


    };


    //blog
//String url = "http://app.hifunki.com/dev_blogstream/blog/comment/send";//评论动态消息
//String url = "http://app.hifunki.com/dev_blogstream/blog/userInfo/share";//分享个人名片到动态
String newDebug= "http://app.hifunki.com/dev_microblog/api/readNewBlogs";//读取最新动态
String newRelease= "https://api.hifunki.com/v_1_0/microblog/api/readNewBlogs";//读取最新动态
//String url = "http://app.hifunki.com/dev_blogstream/blog/send";//发送微博
//String url = "http://app.hifunki.com/dev_blogstream/blog/comment/send";//评论动态消息
//String url = "http://35.164.1.183:7000/blogstream/blog/comment/praise";//评论点赞
//String url = "http://35.164.1.183:7000/blogstream/blog/comment/praise/cancel";//取消评论点赞
//String url = "http://35.164.1.183:7000/microblog/api/getBlogListByTopic";//读取话题动态
String deleteDebug = "http://app.hifunki.com/dev_blogstream/blog/delete";//删除动态
String deleteRelease = "https://api.hifunki.com/v_1_0/blogstream/blog/delete";//删除动态
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
    String recUrl = "http://app.hifunki.com/dev_microblog/api/readRecBlogs";//读取推荐动态
//String url = "http://app.hifunki.com/dev_blogstream/blog/rec/set";//设置推荐动态

    @Test
    public void testRecDynamic(){
        HttpBaseApplicationJson.postFormByApplicationJson(string,recUrl);
    }

    @Test
    public void testNewDynamic(){
                HttpBaseApplicationJson.postFormByApplicationJson(string, newDebug);
    }

    @Test
    public void testDeleteDynamic(){
                HttpBaseApplicationJson.postFormByApplicationJson(string,deleteDebug);
    }

}
