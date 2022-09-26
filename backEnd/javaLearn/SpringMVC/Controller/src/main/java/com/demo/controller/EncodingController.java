package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Fuxx-1
 * @date 2021年07月27日 9:10
 */
@Controller
public class EncodingController {

    @RequestMapping("/e/t1")
    public String encoding(String name, Model model) {
        System.out.println(name);
        model.addAttribute("msg", name);
        return "test";
    }
}
