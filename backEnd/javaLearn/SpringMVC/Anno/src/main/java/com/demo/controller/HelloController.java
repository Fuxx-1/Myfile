package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fuxx-1
 * @date 2021年07月26日 16:54
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        //封装数据
        model.addAttribute("msg", "HelloSpringMVC");
        //会被视图解析器处理
        return "hello";
    }
}
