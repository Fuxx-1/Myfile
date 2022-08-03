package cn.lab.recruitsystem.Util;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @author Eleun
 * @Description
 * @create 2022-07-31 17:09
 */
public class WeChatUtil {
    @Value("wechat.appid")
    public static String WECHAT_APPID;
    @Value("wechat.secret")
    public static String WECHAT_SECRET;
    public static String accessToken = null;
    public static Date expireTime = null;

    /**
     * 获取openid
     * @param code 前端拿到的code
     * @return user的openid
     */
    public static String getOpenid(String code) {
        try {
            Connection connection = Jsoup.connect("https://api.weixin.qq.com/wxa/getpluginopenpid?" +
                    "access_token=" + accessToken);
            connection.data("code", code);
            Document document = connection.ignoreContentType(true).post();
            WeChatOpenid weChatOpenid = JSONObject.parseObject(document.body().text(), WeChatOpenid.class);
            return weChatOpenid.getOpenpid();
        } catch (IOException e) {
            Logger.getLogger("getOpenid()").warning(e.toString());
            return null;

        }
    }

    @Scheduled(cron = "0 */5 * * * *")
    public static void refreshToken() {
        try {
            Connection connection = Jsoup.connect("https://api.weixin.qq.com/cgi-bin/token?" +
                    "grant_type=client_credential" +
                    "&appid=" + WECHAT_APPID +
                    "&secret=" + WECHAT_SECRET);
            Document document = connection.ignoreContentType(true).get();
            WeChatAccessToken weChatAccessToken = JSONObject.parseObject(document.body().text(), WeChatAccessToken.class);
            accessToken = weChatAccessToken.getAccess_token();
        } catch (Exception e) {
            Logger.getLogger("refreshToken()").warning(e.toString());
            refreshToken();  // 出现错误尝试修复
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class WeChatAccessToken {
        private String access_token;
        private String expires_in;
        private Integer errcode;
        private String errmsg;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class WeChatOpenid {
        private String openpid;
        private Integer errcode;
        private String errmsg;
    }
}
