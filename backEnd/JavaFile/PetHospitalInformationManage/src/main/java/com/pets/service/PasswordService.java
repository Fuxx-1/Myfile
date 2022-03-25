package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 11:19
 **/
@Service
public interface PasswordService {
    JSONObject verifypassword(String password);
    JSONObject verifyadmin(String token);
}
