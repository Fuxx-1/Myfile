package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import com.pets.pojo.HospitalPhysician;
import com.pets.service.HospitalPhysicianService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 19:21
 **/
@Controller
public class HospitalPhysicianController {

    @Autowired
    HospitalPhysicianService hospitalPhysicianService;


    public String addHospitalPhysician(HospitalPhysician hospitalPhysician, String token){
        return hospitalPhysicianService.addHospitalPhysician(hospitalPhysician, token).toJSONString();
    }

    public String delHospitalPhysician(String certificateNumber, String token){
        return hospitalPhysicianService.delHospitalPhysician(certificateNumber, token).toJSONString();
    }

    public String updateHospitalPhysician(HospitalPhysician hospitalPhysician, String token){
        return hospitalPhysicianService.updateHospitalPhysician(hospitalPhysician, token).toJSONString();
    }

    public String  queryHospitalPhysicianByName(String certificateNumber){
        return hospitalPhysicianService.queryHospitalPhysicianByName(certificateNumber).toJSONString();
    }
}
