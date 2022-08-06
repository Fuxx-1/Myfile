package cn.lab.recruitsystem.Util;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;

/**
 * @author Eleun
 * @Description
 * @create 2022-07-31 17:09
 */
@Component
public class WeChatUtil {
    private static String WECHAT_APPID;
    private static String WECHAT_SECRET;
    private static String accessToken = null;
    private static Date expireTime = null;

    public static String getOpenid(String code) {
        try {
            Connection connection = Jsoup.connect("https://api.weixin.qq.com/sns/jscode2session");
            connection.data("appid", WECHAT_APPID).data("secret", WECHAT_SECRET)
                    .data("js_code", code).data("grant_type", "authorization_code");
            Document document = connection.ignoreContentType(true).get();
            WechatOpenid wechatOpenid = JSONObject.parseObject(document.body().text(), WechatOpenid.class);
            return wechatOpenid.getOpenid();
        } catch (Exception e) {
            Logger.getLogger("getOpenid()").warning(e.toString());
            return null;
        }
    }

    @Value("${wechat.appid}")
    public void setWechatAppid(String wechatAppid) {
        WECHAT_APPID = wechatAppid;
    }

    @Value("${wechat.secret}")
    public void setWechatSecret(String wechatSecret) {
        WECHAT_SECRET = wechatSecret;
    }


//    @Scheduled(cron = "0 */5 * * * *")
//    public static void refreshToken() {
//        try {
//            Connection connection = Jsoup.connect("https://api.weixin.qq.com/cgi-bin/token?" +
//                    "grant_type=client_credential" +
//                    "&appid=" + WECHAT_APPID +
//                    "&secret=" + WECHAT_SECRET);
//            Document document = connection.ignoreContentType(true).get();
//            WeChatAccessToken weChatAccessToken = JSONObject.parseObject(document.body().text(), WeChatAccessToken.class);
//            accessToken = weChatAccessToken.getAccess_token();
//        } catch (Exception e) {
//            Logger.getLogger("refreshToken()").warning(e.toString());
//            refreshToken();  // 出现错误尝试修复
//        }
//    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class WechatOpenid {
        private String session_key;    // 会话密钥
        private String unionid;    // 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回，详见 UnionID 机制说明。
        private String errmsg;    // 错误信息
        private String openid;    // 用户唯一标识
        private String errcode;    // 错误码
    }
}
