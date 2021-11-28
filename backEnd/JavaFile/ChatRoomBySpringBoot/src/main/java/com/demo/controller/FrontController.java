package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author Fuxx-1
 * @date 2021年10月09日 0:02
 */
@Controller
public class FrontController {
    @PostMapping("/getid")
    @ResponseBody
    @CrossOrigin
    public String getId(HttpSession session) {
        JSONObject resp = new JSONObject();
        if (session.getAttribute("id") != null) {
            resp.put("data", new HashMap<String, Object>(1).put("id", session.getAttribute("id")));
            resp.put("code", 0);
            resp.put("msg", "OK");
            return resp.toJSONString();
        } else {
            resp.put("code", -1);
            resp.put("msg", "未登录");
            return resp.toJSONString();
        }
    }
}
