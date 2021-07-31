package com.demo.controller;

import com.demo.service.WSService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/message")
public class WebSocketController {

    //websocket服务层调用类
    @Autowired
    private WSService wsService;

    @RequestMapping("/{id}")
    public String toSendPage(@PathVariable int id,  Model model) {
        model.addAttribute("id", id);
        return "message";
    }

    //请求入口
    @RequestMapping(value = "/TestWS", method = RequestMethod.GET)
    @ResponseBody
    public String TestWS(@RequestParam(value = "userId", required = true) Long userId,
                         @RequestParam(value = "message", required = true) String message) {
        Logger logger = LoggerFactory.getLogger(WebSocketController.class);
        logger.debug("收到发送请求，向用户{}的消息：{}", userId, message);
        if (wsService.sendToAllTerminal(userId, message)) {
            return "发送成功";
        } else {
            return "发送失败";
        }
    }
}