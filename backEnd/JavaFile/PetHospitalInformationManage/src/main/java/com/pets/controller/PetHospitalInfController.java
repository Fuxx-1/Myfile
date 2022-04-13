package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import com.pets.model.dto.PetHospitalInf;
import com.pets.model.vo.PetHospitalInfVo;
import com.pets.service.PetHospitalInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 19:23
 **/
@Controller
@RequestMapping("/Inf")
@ResponseBody
@CrossOrigin
public class PetHospitalInfController {

    @Autowired
    PetHospitalInfService petHospitalInfService;

    @RequestMapping("/add")
    public String addPetHospitalInf(@RequestBody PetHospitalInfVo petHospitalInfVo){
        return petHospitalInfService.addPetHospitalInf(petHospitalInfVo.getPetHospitalInf(), petHospitalInfVo.getToken()).toJSONString();
    }

    @RequestMapping("/delete")
    public String delPetHospitalInf(@RequestBody PetHospitalInfVo petHospitalInfVo){
        return petHospitalInfService.delPetHospitalInf(petHospitalInfVo.getPetHospitalInf().getId(), petHospitalInfVo.getToken()).toJSONString();
    }

    @RequestMapping("/update")
    public String updatePetHospitalInf(@RequestBody PetHospitalInfVo petHospitalInfVo){
        return petHospitalInfService.updatePetHospitalInf(petHospitalInfVo.getPetHospitalInf(), petHospitalInfVo.getToken()).toJSONString();
    }

    @RequestMapping("/limit")
    public String queryPetHospitalInf(int limit, int page, String field, boolean isDesc, String similarName){
        return petHospitalInfService.queryPetHospitalInf(limit, page, field, isDesc, similarName).toJSONString();
    }

    @RequestMapping("/queryByName")
    public String queryPetHospitalInf(String name){
        return petHospitalInfService.queryPetHospitalInf(name).toJSONString();
    }

    @RequestMapping("/queryById")
    public String queryPetHospitalInf(int id){
        return petHospitalInfService.queryPetHospitalInfById(id).toJSONString();
    }
}
