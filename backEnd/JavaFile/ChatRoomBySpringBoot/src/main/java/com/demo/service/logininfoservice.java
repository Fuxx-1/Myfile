package com.demo.service;

import com.demo.pojo.MoreInfo;
import com.demo.pojo.logInInfo;

import javax.servlet.http.HttpSession;

/**
 * @author Fuxx-1
 * @date 2021年09月21日 23:15
 */
public interface logininfoservice {
    /**
     * 用户登录
     * @return login成功与否
     */
    String loginservice(logInInfo logininfo, HttpSession session);

    /**
     * 用户注册
     * @return 注册是否成功
     */
    String signupservice(logInInfo logininfo);

    /**
     * 修改用户密码
     * @param newPassword 新密码
     * @return 是否修改成功
     */
    String updatePasswordService(HttpSession session, String newPassword);


}
