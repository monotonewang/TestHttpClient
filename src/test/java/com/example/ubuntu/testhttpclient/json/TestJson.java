package com.example.ubuntu.testhttpclient.json;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/29 0029.
 */

public class TestJson {

    @Test
    public void testJSONObject() {
        String string = " {\"id\":5336253600,\"idstr\":\"5336253600\",\"class\":1,\"screen_name\":\"qq772973779\",\"name\":\"qq772973779\",\"province\":\"100\",\"city\":\"1000\",\"location\":\"其他\",\"description\":\"\",\"url\":\"\",\"profile_image_url\":\"http://tva4.sinaimg.cn/crop.0.0.100.100.50/005P8nksjw8elena4v4i0g302s02swee.gif\",\"cover_image_phone\":\"http://ww1.sinaimg.cn/crop.0.0.640.640.640/549d0121tw1egm1kjly3jj20hs0hsq4f.jpg\",\"profile_url\":\"u/5336253600\",\"domain\":\"\",\"weihao\":\"\",\"gender\":\"m\",\"followers_count\":42,\"friends_count\":28,\"pagefriends_count\":0,\"statuses_count\":30,\"favourites_count\":1,\"created_at\":\"Sat Oct 18 00:58:49 +0800 2014\",\"following\":false,\"allow_all_act_msg\":false,\"geo_enabled\":true,\"verified\":false,\"verified_type\":-1,\"remark\":\"\",\"insecurity\":{\"sexual_content\":false},\"status\":{\"created_at\":\"Thu Sep 28 17:06:00 +0800 2017\",\"id\":4157000268772941,\"mid\":\"4157000268772941\",\"idstr\":\"4157000268772941\",\"can_edit\":false,\"text\":\"666666\",\"source_allowclick\":0,\"source_type\":1,\"source\":\"<a href=\\\"http://app.weibo.com/t/feed/6vtZb0\\\" rel=\\\"nofollow\\\">微博 weibo.com</a>\",\"favorited\":false,\"truncated\":false,\"in_reply_to_status_id\":\"\",\"in_reply_to_user_id\":\"\",\"in_reply_to_screen_name\":\"\",\"pic_urls\":[],\"geo\":null,\"is_paid\":false,\"mblog_vip_type\":0,\"reposts_count\":0,\"comments_count\":0,\"attitudes_count\":0,\"pending_approval_count\":0,\"isLongText\":false,\"mlevel\":0,\"visible\":{\"type\":0,\"list_id\":0},\"biz_feature\":0,\"hasActionTypeCard\":0,\"darwin_tags\":[],\"hot_weibo_tags\":[],\"text_tag_tips\":[],\"userType\":0,\"more_info_type\":0,\"positive_recom_flag\":0,\"gif_ids\":\"\",\"is_show_bulletin\":2,\"comment_manage_info\":{\"comment_permission_type\":-1,\"approval_comment_type\":0}},\"ptype\":0,\"allow_all_comment\":true,\"avatar_large\":\"http://tva4.sinaimg.cn/crop.0.0.100.100.180/005P8nksjw8elena4v4i0g302s02swee.gif\",\"avatar_hd\":\"http://tva4.sinaimg.cn/crop.0.0.100.100.1024/005P8nksjw8elena4v4i0g302s02swee.gif\",\"verified_reason\":\"\",\"verified_trade\":\"\",\"verified_reason_url\":\"\",\"verified_source\":\"\",\"verified_source_url\":\"\",\"follow_me\":false,\"like\":false,\"like_me\":false,\"online_status\":0,\"bi_followers_count\":0,\"lang\":\"zh-cn\",\"star\":0,\"mbtype\":0,\"mbrank\":0,\"block_word\":0,\"block_app\":0,\"credit_score\":80,\"user_ability\":1024,\"urank\":6,\"story_read_state\":-1,\"vclub_member\":0}";
        try {
            JSONObject jsonObject=new JSONObject(string);
            String cover_image_phone = jsonObject.getString("cover_image_phone");
            String name = jsonObject.getString("name");
            System.out.println(name);
            System.out.println(cover_image_phone);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
