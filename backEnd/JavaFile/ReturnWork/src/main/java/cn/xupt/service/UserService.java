package cn.lab.recruitsystem.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:06
 */
public interface UserService {
    /**
     * 发送验证邮件验证码
     * @param Email 邮箱
     * @param Action 行为
     * @return 是否成功发送code, msg, data
     */
    JSONObject sendVerifyEmail(String Email, String Action);

    /**
     * 验证验证码
     * @param Email 邮箱
     * @param Code
     * @return 是否正确code, msg, data
     */
    JSONObject verifyCode(String Email, String Code);
}
