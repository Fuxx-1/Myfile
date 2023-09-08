package ltd.newimg.booksystem.controller;


import com.alibaba.fastjson.JSONObject;
import ltd.newimg.booksystem.model.vo.ChangePasswordVO;
import ltd.newimg.booksystem.model.vo.UserVO;
import ltd.newimg.booksystem.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/sign")
    String addUser(@RequestBody UserVO user, HttpServletResponse httpServletResponse) {
        JSONObject jsonObject = userService.signup(user);
        HashMap<String, Object> dataMap = jsonObject.getObject("data", HashMap.class);
        if (dataMap != null) {
            String id = (String) dataMap.get("id");
            if (id != null && !id.isEmpty()) {
                final ResponseCookie responseCookie = ResponseCookie
                        .from("id", id)
                        .secure(true)
                        .httpOnly(true)
                        .path("/")
                        .maxAge(3600)
                        .sameSite("None")
                        .domain("localhost")
                        .build();
                httpServletResponse.addHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());
            }
        }
        return jsonObject.toJSONString();
    }

    @PostMapping("/login")
    String queryUser(@RequestBody UserVO user, HttpServletResponse httpServletResponse) {
        JSONObject jsonObject = userService.login(user);
        HashMap<String, Object> dataMap = jsonObject.getObject("data", HashMap.class);
        if (dataMap != null) {
            String id = (String) dataMap.get("id");
            if (id != null && !id.isEmpty()) {
                final ResponseCookie responseCookie = ResponseCookie
                        .from("id", id)
                        .secure(true)
                        .httpOnly(true)
                        .path("/")
                        .maxAge(3600)
                        .sameSite("None")
                        .domain("localhost")
                        .build();
                httpServletResponse.addHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());
            }
        }
        return jsonObject.toJSONString();
    }

    @PatchMapping("")
    String updateUser(@RequestBody UserVO user) {
        return userService.updateUser(user).toJSONString();
    }

    @PutMapping("")
    String updatePassword(@RequestBody ChangePasswordVO changePassword) {
        return userService.changePassword(changePassword).toJSONString();
    }
}
