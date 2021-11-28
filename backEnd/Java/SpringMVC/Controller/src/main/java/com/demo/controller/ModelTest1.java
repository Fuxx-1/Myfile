package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Fuxx-1
 * @date 2021年07月26日 18:01
 */
@Controller
public class ModelTest1 {
    @RequestMapping("MT1")
    public String test(HttpServletRequest req, HttpServletResponse resp, Model model) {
        HttpSession session = req.getSession();
        model.addAttribute("msg", session.getId());
        return "test";
    }
}
