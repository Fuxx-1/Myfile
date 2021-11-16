package com.main.controller;

import com.alibaba.fastjson.JSONObject;
import com.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/logIn")
    public String logIn(String username, String password) {
        return userService.logIn(username, password).toJSONString();
    }

    @ResponseBody
    @RequestMapping("/signUp")
    public String signUp(String username, String password, String email) {
        return userService.signUp(username, password, email).toJSONString();
    }

    @ResponseBody
    @RequestMapping("/updatePassword")
    public String updatePassword(String username, String password, String email) {
        return userService.updatePassword(username, password, email).toJSONString();
    }

    @ResponseBody
    @RequestMapping("/uploadList")
    public String uploadList(String token, String date, String list) {
        return userService.uploadList(token, date, list).toJSONString();
    }

    @ResponseBody
    @RequestMapping("/getList")
    public String getList(String token, String date) {
        return userService.getList(token, date).toJSONString();
    }

}
