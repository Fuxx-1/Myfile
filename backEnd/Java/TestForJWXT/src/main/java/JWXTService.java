import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import sun.security.mscapi.CKeyPairGenerator;

import java.io.IOException;
import java.security.PublicKey;
import java.security.interfaces.RSAKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fuxx-1
 * @date 2021年08月02日 15:43
 */
public class JWXTService {
    private static final String url = "http://www.zfjw.xupt.edu.cn/jwglxt";
    private static Map<String,String> cookies = new HashMap<>();
    private static String modulus;
    private static String exponent;
    private static String csrftoken;
    private static Connection connection;
    private static Connection.Response response;
    private static Document document;
    private static String stuNum;
    private static String password;


    public static void main(String[] args) {
        connection = Jsoup.connect(url+ "/xtgl/login_getPublicKey.html?" + "time="+ new Date().getTime());
        connection.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        try {
            response = connection.cookies(cookies).ignoreContentType(true).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSON.parseObject(response.body());
        modulus = jsonObject.getString("modulus");
        exponent = jsonObject.getString("exponent");
        byte[] modulus_Decode = Base64.getDecoder().decode(modulus);
        byte[] exponent_Decode = Base64.getDecoder().decode(exponent);
        String mmPassword = RSAEncoderUtil.RSAEncrypt(password, Base64Util.b64tohex(modulus), Base64Util.b64tohex(exponent));
        String RSA_mm = ;
        RSAKey
    }
}
