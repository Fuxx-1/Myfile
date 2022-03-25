package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import com.pets.pojo.HospitalLoc;
import com.pets.service.HospitalLocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 19:21
 **/
@Controller
public class HospitalLocController {

    @Autowired
    HospitalLocService hospitalLocService;

    public String addHospitalLoc(HospitalLoc hospitalLoc, String token){
        return hospitalLocService.addHospitalLoc(hospitalLoc, token).toJSONString();
    }

    public String delHospitalLoc(int id, String token){
        return hospitalLocService.delHospitalLoc(id, token).toJSONString();
    }

    public String updateHospitalLoc(HospitalLoc hospitalLoc, String token){
        return hospitalLocService.updateHospitalLoc(hospitalLoc, token).toJSONString();
    }

    public String queryHospitalLoc(int id){
        return hospitalLocService.queryHospitalLoc(id).toJSONString();
    }
}
