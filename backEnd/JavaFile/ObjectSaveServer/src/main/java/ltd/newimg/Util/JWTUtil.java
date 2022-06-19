package ltd.newimg.Util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

@Component
public class JWTUtil {

    /**
     * key（按照签名算法的字节长度设置key）
     */
    private final static String SECRET_KEY = System.getenv("JWTKey") == null ? "7tyegruegrui7y4t38erigbdvfhzhiwe378" : System.getenv("JWTKey");
    /**
     * 过期时间（毫秒单位）
     */
    private final static long TOKEN_EXPIRE_MILLIS = 1000 * 60 * 60 * 12;

    /**
     * 创建token
     * @param claimMap
     * @return
     */
    public static String createToken(Map<String, Object> claimMap) {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                // 设置签发时间
                .setIssuedAt(new Date(currentTimeMillis))
                // 设置过期时间
                .setExpiration(new Date(currentTimeMillis + TOKEN_EXPIRE_MILLIS))
                .addClaims(claimMap)
                .signWith(generateKey())
                .compact();
    }

    /**
     * 验证token
     * @param token
     * @return 0 验证成功，1 验证失败
     */
    public static int verifyToken(String token) {
        try {
            Jwts.parser().setSigningKey(generateKey()).parseClaimsJws(token);
            return 0;
        } catch (Exception e) {
            // 日志输出错误
            Logger.getLogger("com.pets.util.JWTUtil").warning("Token验证失败，caused by: " + e.toString());
            return 1;
        }
//        catch (ExpiredJwtException e) {
//            e.printStackTrace();
//            return 1;
//        } catch (UnsupportedJwtException e) {
//            e.printStackTrace();
//            return 2;
//        } catch (MalformedJwtException e) {
//            e.printStackTrace();
//            return 3;
//        } catch (SignatureException e) {
//            e.printStackTrace();
//            return 4;
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//            return 5;
//        }
    }


    /**
     * 解析token
     * @param token
     * @return
     */
    public static Map<String, Object> parseToken(String token) {
        // 得到DefaultJwtParser
        return Jwts.parser()
                // 设置签名密钥
                .setSigningKey(generateKey())
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 生成安全密钥
     * @return
     */
    public static Key generateKey() {
        return new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }
}
