package com.pets.controller;

import com.pets.model.vo.Password;
import com.pets.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 19:23
 **/
@Controller
@RequestMapping("/pwd")
@ResponseBody
@CrossOrigin
public class passwordController {

    @Autowired
    PasswordService passwordService;

    @PostMapping("/getToken")
    public String verifypassword(@RequestBody Password password) {
        return passwordService.verifypassword(password.getPassword()).toJSONString();
    }

    @RequestMapping("/verifyToken")
    public String verifyToken(@RequestBody Password token) {
        return passwordService.verifyToken(token.getToken()).toJSONString();
    }

}
