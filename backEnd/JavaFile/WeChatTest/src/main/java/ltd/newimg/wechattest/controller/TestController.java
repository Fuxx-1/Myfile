package ltd.newimg.wechattest.controller;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.wechattest.model.Openid;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author Eleun
 * @Description
 * @create 2022-07-31 11:13
 */
@RestController
@CrossOrigin
public class TestController {
    @Value("${wechat.appid}")
    public static final String APP_ID = "";
    @Value("${wechat.secret}")
    public static final String SECRET = "";


    @RequestMapping("/getInfo")
    String frontView(String code, String state) {
        JSONObject object = new JSONObject();
        object.put("code", code);
        object.put("state", state);
        Connection openidConnection = Jsoup.connect("https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=" + APP_ID + "&" +
                "secret=" + SECRET + "&" +
                "code=" + code + "&" +
                "grant_type=authorization_code");
        Document openidBody = null;
        try {
            openidBody = openidConnection.ignoreContentType(true).get();
        } catch (IOException e) {
            // ignore
        }
        Openid openidResult = (Openid) JSONObject.parse(String.valueOf(openidBody.body()));
        Connection userInfoConnection = Jsoup.connect("https://api.weixin.qq.com/sns/userinfo?" +
                "access_token=" + openidResult.getAccess_token() + "&" +
                "openid=" + openidResult.getOpenid() + "&" +
                "lang=zh_CN");
        Document userInfo = null;
        try {
            userInfo = userInfoConnection.ignoreContentType(true).get();
        } catch (IOException e) {
            // ignore
        }
        object.put("openid", openidBody.body());
        object.put("userInfo", userInfo.body());
        return object.toJSONString();
    }

    @RequestMapping("/test")
    String test() {
        return "Welcome_to_test";
    }


    public static final String Token = "Welcome_to_test"; //微信公众平台中设置的token

    @RequestMapping("/")
    public void index(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String method = request.getMethod();
        if ("GET".equals(method)) {
            // 微信加密签名
            String signature = request.getParameter("signature");
            // 随机字符串
            String echostr = request.getParameter("echostr");
            // 时间戳
            String timestamp = request.getParameter("timestamp");
            // 随机数
            String nonce = request.getParameter("nonce");
            String[] str = {Token, timestamp, nonce};
            // 字典排序
            Arrays.sort(str);
            String bigStr = str[0] + str[1] + str[2];
            // SHA1加密
            String digest = sha1(bigStr);
            // 确认请求来至微信
            if (digest.equals(signature)) {
                response.getWriter().print(echostr);
            }
        }
    }

    /**
     * @description: sha1
     * @author: lvyq
     * @date: 2022/7/8 15:18
     * @version 1.0
     */

    public static String sha1(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        //把字符串转为字节数组
        byte[] b = data.getBytes();
        //使用指定的字节来更新我们的摘要
        md.update(b);
        //获取密文  （完成摘要计算）
        byte[] b2 = md.digest();
        //获取计算的长度
        int len = b2.length;
        //16进制字符串
        String str = "0123456789abcdef";
        //把字符串转为字符串数组
        char[] ch = str.toCharArray();
        //创建一个40位长度的字节数组
        char[] chs = new char[len * 2];
        //循环20次
        for (int i = 0, k = 0; i < len; i++) {
            //获取摘要计算后的字节数组中的每个字节
            byte b3 = b2[i];
            // >>>:无符号右移
            // &:按位与
            //0xf:0-15的数字
            chs[k++] = ch[b3 >>> 4 & 0xf];
            chs[k++] = ch[b3 & 0xf];
        }
        //字符数组转为字符串
        return new String(chs);
    }


}
