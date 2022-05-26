package com.example.demo.contoller;

import com.example.demo.model.vo.idvo;
import com.example.demo.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-14 21:20
 */
@Controller
@RequestMapping("/Test")
@ResponseBody
@CrossOrigin
public class TestController {

    @Resource
    TestService testService;

    @RequestMapping("/test")
    public String queryTest(@RequestBody idvo idvo) {
        return testService.queryTest(idvo.getId()).toJSONString();
    }
}
