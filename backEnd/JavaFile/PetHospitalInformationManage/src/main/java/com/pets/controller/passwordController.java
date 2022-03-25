package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import com.pets.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 19:23
 **/
@Controller
public class passwordController {
    @Autowired
    PasswordService passwordService;

    public String verifypassword(String password){
        return passwordService.verifypassword(password).toJSONString();
    }

    public String verifyadmin(String token){
        return passwordService.verifyadmin(token).toJSONString();
    }

}
