package com.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.demo.mapper.logInInfoMapper;
import com.demo.pojo.logInInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

/**
 * @author Fuxx-1
 * @date 2021年09月22日 0:06
 */
@Service
public class logininfoserviceImpl implements logininfoservice {
    @Autowired
    logInInfoMapper logInInfoMapper;

    /**
     * 用户登录
     *
     * @return login成功与否
     */
    @Override
    public String loginservice(logInInfo logininfo, HttpSession session) {
        JSONObject resp = new JSONObject();
        logInInfo pwd = logInInfoMapper.querypwd(logininfo.getId());
        if (pwd == null) {
            resp.put("code", -1);
            resp.put("msg", "用户不存在");
        } else if (pwd.getPassword().equals(logininfo.getPassword())) {
            resp.put("code", 0);
            session.setAttribute("id", logininfo.getId());
        } else {

            resp.put("code", -2);
            resp.put("msg", "密码错误");
        }
        return resp.toJSONString();
    }

    /**
     * 修改用户密码
     *
     * @param id          用户id
     * @param newPassword 新密码
     * @param OldPassword 旧密码
     * @return 是否修改成功
     */
    @Override
    public String updatePasswordService(HttpSession session, String newPassword) {
        JSONObject resp = new JSONObject();
        if (session.getAttribute("id") != null) {
            if (logInInfoMapper.updatePassword(new logInInfo((Integer) session.getAttribute("id"), newPassword))) {
                resp.put("code", 0);
            } else {
                resp.put("code", -2);
                resp.put("msg", "修改失败");
            }
        } else {
            resp.put("code", -1);
            resp.put("msg", "密码错误");
        }
        return resp.toJSONString();
    }

    /**
     * 用户注册
     *
     * @return 注册是否成功
     */
    @Override
    public String signupservice(logInInfo logininfo) {
        JSONObject resp = new JSONObject();
        logInInfo pwd = logInInfoMapper.querypwd(logininfo.getId());
        if (pwd == null) {
            boolean isComplete = logInInfoMapper.addlogininfo(logininfo);
            if (isComplete) {
                resp.put("code", 0);
            } else {
                resp.put("code", -2);
                resp.put("msg", "用户增加失败");
            }
        } else {
            resp.put("code", -1);
            resp.put("msg", "用户已存在");
        }
        return resp.toJSONString();
    }
}
