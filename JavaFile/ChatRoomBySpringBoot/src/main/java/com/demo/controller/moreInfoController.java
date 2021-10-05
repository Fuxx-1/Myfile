package com.demo.controller;

import com.demo.pojo.MoreInfo;
import com.demo.service.MoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Fuxx-1
 * @date 2021年09月27日 20:20
 */
@Controller
public class moreInfoController {
    @Autowired
    MoreInfoService moreInfoService;

    @PostMapping("/updatemoreinfo")
    @ResponseBody
    @CrossOrigin
    public String updatemoreinfo(MoreInfo moreInfo, HttpSession session) {
        return moreInfoService.updateMoreInfoService(moreInfo, session);
    }

    @PostMapping("/querymoreinfo")
    @ResponseBody
    @CrossOrigin
    public String querymoreinfo(int id) {
        return moreInfoService.queryMoreInfoService(id);
    }

    @PostMapping("/querynickname")
    @ResponseBody
    @CrossOrigin
    public String querynickname(int id) {
        return moreInfoService.queryNickname(id);
    }
}
