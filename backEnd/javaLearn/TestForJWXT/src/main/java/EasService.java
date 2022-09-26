//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Fuxx-1
// * @date 2021年08月02日 15:34
// */
//public class EasService {
//    private final String url = "http://www.zfjw.xupt.edu.cn/";
//    private Map<String,String> cookies = new HashMap<>();
//    private String modulus;
//    private String exponent;
//    private String csrftoken;
//    private Connection connection;
//    private Connection.Response response;
//    private Document document;
//    private String stuNum;
//    private String password;
//    public EasService(){
//    }
//    public ResponseCode login(String stuNum,String password) throws Exception{
//        log.info("通过教务系统登录：学号={}",stuNum);
//        this.stuNum = stuNum;
//        this.password = password;
//        getCsrftoken();
//        getRSApublickey();
//        return beginLogin();
//    }
//    // 获取csrftoken和Cookies
//    public void getCsrftoken(){
//        try{
//            connection = Jsoup.connect(url+ "/xtgl/login_slogin.html?language=zh_CN&_t="+new Date().getTime());
//            connection.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
//            response = connection.execute();
//            cookies = response.cookies();
//            //保存csrftoken
//            document = Jsoup.parse(response.body());
//            csrftoken = document.getElementById("csrftoken").val();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//    // 获取公钥(是通过modulus和exponent加密而来的)并加密密码
//    public void getRSApublickey() throws Exception{
//        connection = Jsoup.connect(url+ "/xtgl/login_getPublicKey.html?" +
//                "time="+ new Date().getTime());
//        connection.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
//        response = connection.cookies(cookies).ignoreContentType(true).execute();
//        JSONObject jsonObject = JSON.parseObject(response.body());
//        modulus = jsonObject.getString("modulus");
//        exponent = jsonObject.getString("exponent");
//        String mmPassword = RSAEncoderUtil.RSAEncrypt(password, Base64Util.b64tohex(modulus), Base64Util.b64tohex(exponent));
//        password =  Base64Util.hex2b64(mmPassword);
//    }
//    //登录
//    public ResponseCode beginLogin() throws Exception{
//        connection = Jsoup.connect(url+ "/xtgl/login_slogin.html");
//        connection.header("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
//        connection.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
//        connection.data("csrftoken",csrftoken);
//        connection.data("yhm",stuNum);
//        connection.data("mm",password);
//        connection.data("mm",password);
//        connection.cookies(cookies).ignoreContentType(true)
//                .method(Connection.Method.POST).execute();
//        response = connection.execute();
//        document = Jsoup.parse(response.body());
//        if(document.getElementById("tips") == null){
//            return ResponseCode.success(cookies);
//        }else{
//            return ResponseCode.error(document.getElementById("tips").text());
//        }
//    }
//}
