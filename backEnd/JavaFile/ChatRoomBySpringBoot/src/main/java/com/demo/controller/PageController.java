package com.demo.controller;

/**
 * @author Fuxx-1
 * @date 2021年10月03日 20:14
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/socket")
    public String socket() {
        return "WebSocket";
    }

}
