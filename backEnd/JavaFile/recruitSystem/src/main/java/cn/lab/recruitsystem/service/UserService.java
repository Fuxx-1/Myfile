package cn.lab.recruitsystem.service;

import cn.lab.recruitsystem.Model.dto.User;
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

    /**
     * 注册新用户
     * @param Email 邮箱
     * @param userid 学号
     * @param VerifyCode 验证码
     * @param password 密码
     * @return 是否注册成功
     */
    JSONObject signup(String Email, String userid, String VerifyCode, String password);

    /**
     * 已注册使用密码登录，未注册可使用教务系统用户密码自动注册登录
     * @param userid 用户id
     * @param password 密码
     * @return Token和登录状态
     */
    JSONObject login(String userid, String password);

    /**
     * 更新信息
     *
     * @param user 用户id，及要更新的信息
     * @return 执行结果
     */
    JSONObject updataInf(User user);

    /**
     * 更新密码和新邮箱
     * @param userid 用户id
     * @param password 密码，第一顺位
     * @param verifyCode 验证码，第二顺位
     * @param new_password 新密码
     * @param newEmail 新邮箱
     * @return 执行结果
     */
    JSONObject resetMainInf(String userid, String password, String verifyCode, String new_password, String newEmail);

    /**
     * 签到
     * @param userid 用户id
     * @param is_sign 是否签到
     * @return 执行结果
     */
    JSONObject sign(String userid, Boolean is_sign);

    /**
     * 授权
     * @param userid 被授权的用户id
     * @return 结果
     */
    JSONObject changeAuth(String userid);

    /**
     * 获取用户信息
     * @param userid 用户id
     * @return 用户信息
     */
    JSONObject getInf(String userid);
}
