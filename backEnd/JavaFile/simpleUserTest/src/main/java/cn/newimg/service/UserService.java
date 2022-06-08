package cn.newimg.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:06
 */
public interface UserService {
    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     * @return 是否成功
     */
    JSONObject addUser(String username, String password);

    /**
     * 删除用户
     * @param username 用户名
     * @param password 密码
     * @return 是否成功
     */
    JSONObject delUser(String username, String password);

    /**
     * 更新密码
     * @param username 用户名
     * @param old_password 旧密码
     * @param new_password 新密码
     * @return 是否成功
     */
    JSONObject updateUser(String username, String old_password, String new_password);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 登陆状态
     */
    JSONObject login(String username, String password);
}
