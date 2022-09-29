package cn.newimg.Util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-09-27 17:52
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ReturnCodeEnum {
    SUCCESS(0,"成功"),
    TEST(0,"Welcome to simpleUserTamplate"),
    ACCESS_DENIED(1001,"登录过期");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
