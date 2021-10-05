package com.demo.controller;

import com.demo.pojo.Friend;
import com.demo.service.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Fuxx-1
 * @date 2021年09月27日 21:00
 */
@Controller
public class friendController {
    @Autowired
    friendService friendService;

    @PostMapping("/addfriend")
    @ResponseBody
    @CrossOrigin
    public String addFriendInfo(int friendId, HttpSession session) {
        return friendService.addFriendInfo(friendId, session);
    }

    @PostMapping("/delfriend")
    @ResponseBody
    @CrossOrigin
    public String deleteFriendInfo(int friendId, HttpSession session) {
        return friendService.deleteFriendInfo(friendId, session);
    }

    @PostMapping("/queryfriend")
    @ResponseBody
    @CrossOrigin
    public String queryFriendInfo(HttpSession session) {
        return friendService.queryFriendInfo(session);
    }

    @PostMapping("/updatefriend")
    @ResponseBody
    @CrossOrigin
    public String updateState(int friendId, HttpSession session) {
        return friendService.updateState(friendId, session);
    }
}
