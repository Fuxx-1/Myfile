package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fuxx-1
 * @date 2021年08月02日 10:38
 */
@RestController
public class AJAXController {

    @RequestMapping("/t1")
    public String Test() {
        return "Hello";
    }

}
