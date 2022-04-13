package com.pets.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 11:19
 **/
public interface PasswordService {
    JSONObject verifypassword(String password);
    JSONObject verifyToken(String token);
}
