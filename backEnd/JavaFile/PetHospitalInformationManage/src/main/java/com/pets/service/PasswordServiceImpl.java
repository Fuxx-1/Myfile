package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.passwordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.main.util.JWTUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 11:20
 **/
@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private passwordMapper passwordMapper;

    @Override
    public JSONObject verifypassword(String password) {
        //返回体
        JSONObject resp = new JSONObject();
        if (passwordMapper.querypassword().equals(password)) {
            //密码正确
            resp.put("code", 0);
            resp.put("data", JWTUtil.createToken((Map<String, Object>) new HashMap<String, Object>().put("pwd", password)));
        } else {
            //密码错误
            resp.put("code", -1);
            resp.put("msg", "密码错误或系统繁忙");
        }
        return resp;
    }

    @Override
    public JSONObject verifyToken(String token) {
        //返回体
        JSONObject resp = new JSONObject();
        if (JWTUtil.verifyToken(token) == 0) {
            resp.put("code", 0);
        } else {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
        }
        return resp;
    }
}
