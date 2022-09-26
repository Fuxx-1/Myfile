package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fuxx-1
 * @date 2021年07月26日 17:37
 */
@Controller
@RequestMapping("admin")
public class ControllerTest3 {

    @RequestMapping("/t1")
    public String Test3(Model model) {
        model.addAttribute("msg", "admin!");
        return "test";
    }
}
