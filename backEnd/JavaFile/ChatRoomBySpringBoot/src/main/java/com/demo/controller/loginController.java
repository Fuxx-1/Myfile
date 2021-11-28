package com.demo.controller;

import com.demo.pojo.logInInfo;
import com.demo.service.logininfoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author Fuxx-1
 * @date 2021年09月21日 22:53
 */
@Controller
public class loginController {
    @Autowired
    logininfoservice logininfoservice;

    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin
    public String login(logInInfo logininfo, HttpSession session) {
        return logininfoservice.loginservice(logininfo, session);
    }

    @PostMapping("/signup")
    @ResponseBody
    @CrossOrigin
    public String signup(logInInfo logininfo) {
        return logininfoservice.signupservice(logininfo);
    }

    @PostMapping("/updatepassword")
    @ResponseBody
    @CrossOrigin
    public String updatePassword(String oldPassword, String newPassword, HttpSession session) {
        return logininfoservice.updatePasswordService(session, newPassword);
    }
}
