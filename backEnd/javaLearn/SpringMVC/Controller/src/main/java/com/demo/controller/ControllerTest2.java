package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fuxx-1
 * @date 2021年07月26日 17:25
 */
@Controller
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test2(Model model) {
        model.addAttribute("msg", "ControllerTest2");
        return "test";
    }
}
