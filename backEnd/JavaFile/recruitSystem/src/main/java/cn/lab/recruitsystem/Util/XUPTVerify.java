package cn.lab.recruitsystem.Util;

import com.google.gson.Gson;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class XUPTVerify {
    private static final String TOKEN = "csrftoken";
    private static final String JSESSIONID = "JSESSIONID";
    private static final String MODULUS = "modulus";
    private static final String EXPONENT = "exponent";
    private static Base64 base64 = new Base64();
    private static RSA rsa = new RSA();


    /**
     * 经过系统服务器的验证
     */
    public Map<String, Object> verify(String stuID, String password) throws Exception {

        Map<String, Object> tokenAndCookie = new HashMap<>();

        //拿到Cookie
        tokenAndCookie = getTokenAndCookie();
        //将密码进行加密、编码
        String encryPassword = RSA(password, (Map<String, String>) tokenAndCookie.get(JSESSIONID));
        //构建模拟请求
        Connection connection = Jsoup.connect(HttpURL.POST_URL);
        connection.header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        connection.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
        //添加表单提交的数据
        connection.data("csrftoken", tokenAndCookie.get(TOKEN).toString());
        connection.data("yhm", stuID);
        connection.data("mm", encryPassword);

        Connection.Response res = connection.cookies((Map<String, String>) tokenAndCookie.get(JSESSIONID))
                .ignoreContentType(true).method(Connection.Method.POST).execute();

        tokenAndCookie.put("JSESSIONID", res.cookies());

        //得到模拟请求的response
        Connection.Response response = connection.execute();

        //分析返回的HTML
        Document document = Jsoup.parse(response.body());

        //如果有id为tips的标签，说明登录失败，并将失败信息返回
        Element result = document.getElementById("tips");

        if (!ObjectUtils.isEmpty(result)) {
            return null;
        }
        return tokenAndCookie;
    }

    /**
     * 拉取个人基本信息
     */
    public Map<String, String> getStuInfo(String stuID, String password) throws Exception {

        Map<String, Object> tokenAndCookie = verify(stuID, password);

        if (tokenAndCookie == null) {
            return null;
        }

        Connection connection = Jsoup.connect("http://www.zfjw.xupt.edu.cn/jwglxt/xsxxxggl/xsgrxxwh_cxXsgrxx.html?gnmkdm=N100801&layout=default&su=" + stuID);
        connection.header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        connection.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
        connection.cookies((Map<String, String>) tokenAndCookie.get(JSESSIONID));
        Connection.Response response = connection.ignoreContentType(true).execute();
        Element element = Jsoup.parse(response.body()).body();

        Map<String, String> map = new HashMap<>(4);
        //姓名
        Element nameElement = element.getElementById("col_xm");
        String name = nameElement.text();
        map.put("name", name);

        //学院
        Element academyElement = element.getElementById("col_jg_id");
        String academy = academyElement.text();
        map.put("academy", academy);

        //班级
        Element lessonElement = element.getElementById("col_bh_id");
        String group = lessonElement.text();
        map.put("group", group);

        // 性别
        Element genderElement = element.getElementById("col_xbm");
        if ("男".equals(genderElement.text())) {
            map.put("gender", "M");
        } else {
            map.put("gender", "F");
        }
        return map;
    }

    /**
     * 拉取学生课表
     */
    public String getStudentCourseTable(String stuID, String password, String year, String semester) throws Exception {
        Map<String, Object> tokenAndCookie = verify(stuID, password);
        if (tokenAndCookie == null) {
            return null;
        }
        Connection connection = Jsoup.connect("http://www.zfjw.xupt.edu.cn/jwglxt/kbcx/xskbcx_cxXsKb.html?gnmkdm=N2151&xnm=" + year + "&xqm=" + semester).ignoreContentType(true);
        connection.header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        connection.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
        connection.cookies((Map<String, String>) tokenAndCookie.get(JSESSIONID));
        Connection.Response response = connection.execute();

        String courseTable = Jsoup.parse(response.body()).body().toString().substring(7);
        courseTable = courseTable.substring(0, courseTable.indexOf("</body>") - 1);

        return courseTable;
    }

    /**
     * 拉取学生成绩
     */
    public String getStudentScore(String stuID, String password, String year, String month) throws Exception {
        Map<String, Object> tokenAndCookie = verify(stuID, password);
        if (tokenAndCookie == null) {
            return null;
        }
        Connection connection = Jsoup.connect("http://www.zfjw.xupt.edu.cn/jwglxt/cjcx/cjcx_cxDgXscj.html?doType=query&gnmkdm=N305005&queryModel.showCount=30&xnm=" + year + "&xqm=" + month).ignoreContentType(true);
        connection.header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        connection.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
        connection.cookies((Map<String, String>) tokenAndCookie.get(JSESSIONID));
        Connection.Response response = connection.ignoreContentType(true).followRedirects(true).execute();

        Element element = Jsoup.parse(response.body()).body();

        String scoreTable = Jsoup.parse(response.body()).body().toString().substring(7);
        scoreTable = scoreTable.substring(0, scoreTable.indexOf("</body>") - 1);
        return scoreTable;
    }

    /**
     * 向网页发一次请求，获取Cookie
     */
    private Map<String, Object> getTokenAndCookie() throws IOException {
        Connection connection = Jsoup.connect(HttpURL.XUPT_URL + System.currentTimeMillis());
        connection.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
        connection.header("Cache-Control", "no-cache");
        connection.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        connection.header("Accept-Language", "zh-CN,zh;q=0.9");
        connection.header("Upgrade-Insecure-Requests", "1");
        connection.header("Connection", "keep-alive");
        Connection.Response response = connection.execute();
        Map<String, Object> result = new HashMap<>();
        //保存cookie
        result.put(JSESSIONID, response.cookies());
        //保存token
        Document document = Jsoup.parse(response.body());
        String token = document.getElementById(TOKEN).val();
        result.put(TOKEN, token);
        return result;
    }

    /**
     * 将密码通过RSA公钥进行加密
     */
    private String RSA(String password, Map<String, String> cookies) throws Exception {
        //获取公钥
        Map<String, String> publicKeyMap = getPublicKey(cookies);
        //进行加密
        String encrptPassword = rsa.RSAEncrypt(password, base64.b64tohex(publicKeyMap.get(MODULUS)), base64.b64tohex(publicKeyMap.get(EXPONENT)));
        //将加密后的密码进行Base64编码，并返回
        return base64.hex2b64(encrptPassword);
    }

    /**
     * 通过添加Cookie值，获取RSA加密的公钥
     */
    private Map<String, String> getPublicKey(Map<String, String> cookies) throws Exception {
        Connection connection = Jsoup.connect(HttpURL.PUBLIC_KEY_URL + System.currentTimeMillis());
        connection.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
        Connection.Response response = connection.cookies(cookies).ignoreContentType(true).execute();
        Gson gson = new Gson();
        PublicKey publicKey = gson.fromJson(response.body(), PublicKey.class);
        Map<String, String> result = new HashMap<>();
        result.put(MODULUS, publicKey.getModulus());
        result.put(EXPONENT, publicKey.getExponent());
        return result;
    }

}




