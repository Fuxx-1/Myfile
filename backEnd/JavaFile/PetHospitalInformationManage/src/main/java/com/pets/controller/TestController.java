package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-27 09:02
 **/
@Controller
@ResponseBody
@CrossOrigin
public class TestController {

    @RequestMapping("/")
    String test() {
        return "Welcome to PetHospitalInformationManageSystem!";
    }

    @RequestMapping("/prohibit")
    String prohibit() {
        JSONObject resp = new JSONObject();
        resp.put("msg", "该功能被禁用");
        resp.put("code", 1);
        return resp.toJSONString();
    }

}
