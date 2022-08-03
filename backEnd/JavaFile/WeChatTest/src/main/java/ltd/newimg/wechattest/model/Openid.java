package ltd.newimg.wechattest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-07-31 12:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Openid {
    private String access_token;	//网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
    private String expires_in;	//access_token接口调用凭证超时时间，单位（秒）
    private String refresh_token;	//用户刷新access_token
    private String openid;	//用户唯一标识
    private String scope;	//用户授权的作用域，使用逗号（,）分隔
}
