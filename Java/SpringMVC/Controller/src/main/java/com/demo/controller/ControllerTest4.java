package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fuxx-1
 * @date 2021年07月26日 17:37
 */
@Controller
public class ControllerTest4 {

    //http://localhost:8080/add?a=1&b=2
    @RequestMapping("/add")
    public String test4(int a, int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", res);
        return "test";
    }

    @RequestMapping(value = "/add2/{a}/{b}")
//    @GetMapping("/add2/{a}/{b}")
    public String test5(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", res);
        return "test";
    }
}
