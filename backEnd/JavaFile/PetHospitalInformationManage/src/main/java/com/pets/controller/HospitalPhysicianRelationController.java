package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import com.pets.service.HospitalPhysicianRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 19:21
 **/
@Controller
public class HospitalPhysicianRelationController {

    @Autowired
    HospitalPhysicianRelationService hospitalPhysicianRelationService;

    public String addHospitalPhysicianRelation(int hospitalId, String certificateNumber, String token){
        return hospitalPhysicianRelationService.addHospitalPhysicianRelation(hospitalId, certificateNumber, token).toJSONString();
    }

    public String delHospitalPhysicianRelation(int hospitalId, String certificateNumber, String token){
        return hospitalPhysicianRelationService.delHospitalPhysicianRelation(hospitalId, certificateNumber, token).toJSONString();
    }

    public String queryHospitalPhysicianRelation(int hospitalId){
        return hospitalPhysicianRelationService.queryHospitalPhysicianRelation(hospitalId).toJSONString();
    }
}
