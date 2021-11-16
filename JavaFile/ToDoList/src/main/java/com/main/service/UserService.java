package com.main.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    JSONObject logIn(String username, String password);
    JSONObject signUp(String username, String password, String email);
    JSONObject updatePassword(String username, String password, String email);
    JSONObject uploadList(String token, String date, String list);
    JSONObject getList(String token, String date);
}
