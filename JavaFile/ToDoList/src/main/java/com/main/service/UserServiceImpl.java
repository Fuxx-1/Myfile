package com.main.service;

import com.alibaba.fastjson.JSONObject;
import com.main.mapper.ListMapper;
import com.main.mapper.UserMapper;
import com.main.pojo.ToDoList;
import com.main.pojo.User;
import com.main.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;

    @Autowired
    private ListMapper listMapper;

    @Override
    public JSONObject logIn(String username, String password) {
        JSONObject resp = new JSONObject();
        // 获取用户信息
        User user = null;
        try {
            user = usermapper.getUser(username);
        } catch (Exception e) {
            resp.put("msg", "系统繁忙");
            resp.put("code", -1);
            return resp;
        }
        if (user == null) {
            // 用户不存在
            resp.put("msg", "用户不存在");
            resp.put("code", -1);
        } else {
            if (user.getPassword().equals(password)) {
                //登陆成功
                Map<String, Object> temp = new HashMap<>();
                temp.put("username", username);
                temp.put("email", user.getEmail());
                resp.put("data", JWTUtil.createToken(temp));
                resp.put("code", 0);
            } else {
                //密码错误
                resp.put("msg", "密码错误");
                resp.put("code", -1);
            }
        }
        return resp;
    }

    @Override
    public JSONObject signUp(String username, String password, String email) {
        JSONObject resp = new JSONObject();
        if (usermapper.getUser(username) == null) {
            if (usermapper.setUser(new User(username, password, email))) {
                resp.put("code", 0);
            } else {
                resp.put("msg", "系统繁忙");
                resp.put("code", -1);
            }
        }
        return resp;
    }

    @Override
    public JSONObject updatePassword(String username, String password, String email) {
        JSONObject resp = new JSONObject();
        // 获取用户信息
        User user = null;
        try {
            user = usermapper.getUser(username);
        } catch (Exception e) {
            resp.put("msg", "系统繁忙");
            resp.put("code", -1);
            return resp;
        }
        if (email.equals(user.getEmail())) {
            if (usermapper.setUser(new User(username, password, email))) {
                resp.put("code", 0);
            } else {
                //密码错误
                resp.put("msg", "系统繁忙，修改失败");
                resp.put("code", -1);
            }
        } else {
            //密码错误
            resp.put("msg", "email错误");
            resp.put("code", -1);
        }
        return resp;
    }

    @Override
    public JSONObject getList(String token, String date) {
        JSONObject resp = new JSONObject();
        Map<String, Object> map = null;
        try {
            map = JWTUtil.parseToken(token);
        } catch (Exception e) {
            resp.put("msg", "系统繁忙");
            resp.put("code", -1);
            return resp;
        }
        String username = (String) map.get("username");
        try {
            resp.put("data", listMapper.getList(username, date));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("msg", "系统繁忙");
            resp.put("code", -1);
            return resp;
        }
        return resp;
    }

    @Override
    public JSONObject uploadList(String token, String date, String list) {
        JSONObject resp = new JSONObject();
        Map<String, Object> map = null;
        try {
            map = JWTUtil.parseToken(token);
        } catch (Exception e) {
            resp.put("msg", "系统繁忙");
            resp.put("code", -1);
            return resp;
        }
        String username = (String) map.get("username");
        try {
            if (listMapper.setList(new ToDoList(username, date, list))) {
                resp.put("code", 0);
            } else {
                resp.put("msg", "系统繁忙");
                resp.put("code", -1);
            }
        } catch (Exception e) {
            resp.put("msg", "系统繁忙");
            resp.put("code", -1);
            return resp;
        }
        return resp;
    }
}
