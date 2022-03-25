package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import com.pets.pojo.PetHospitalInf;
import com.pets.service.PetHospitalInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 19:23
 **/
@Controller
public class PetHospitalInfController {

    @Autowired
    PetHospitalInfService petHospitalInfService;

    public String addPetHospitalInf(PetHospitalInf petHospitalInf, String token){
        return petHospitalInfService.addPetHospitalInf(petHospitalInf, token).toJSONString();
    }

    public String delPetHospitalInf(int id, String token){
        return petHospitalInfService.delPetHospitalInf(id, token).toJSONString();
    }

    public String updatePetHospitalInf(PetHospitalInf petHospitalInf, String token){
        return petHospitalInfService.updatePetHospitalInf(petHospitalInf, token).toJSONString();
    }

    public String queryPetHospitalInf(int limit, int page){
        return petHospitalInfService.queryPetHospitalInf(limit, page).toJSONString();
    }

    public String queryPetHospitalInf(String name){
        return petHospitalInfService.queryPetHospitalInf(name).toJSONString();
    }
}
