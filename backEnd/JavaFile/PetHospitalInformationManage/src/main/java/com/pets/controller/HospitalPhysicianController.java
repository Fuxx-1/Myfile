package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import com.pets.model.dto.HospitalPhysician;
import com.pets.model.vo.HospitalPhysicianVo;
import com.pets.service.HospitalPhysicianService;
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
 * @create: 2022-03-25 19:21
 **/
@Controller
@RequestMapping("/Physician")
@ResponseBody
@CrossOrigin
public class HospitalPhysicianController {

    @Autowired
    HospitalPhysicianService hospitalPhysicianService;

    @RequestMapping("/add")
    public String addHospitalPhysician(@RequestBody HospitalPhysicianVo hospitalPhysicianVo){
        return hospitalPhysicianService.addHospitalPhysician(hospitalPhysicianVo.getHospitalPhysician(), hospitalPhysicianVo.getToken()).toJSONString();
    }

    @RequestMapping("/delete")
    public String delHospitalPhysician(@RequestBody HospitalPhysicianVo hospitalPhysicianVo){
        return hospitalPhysicianService.delHospitalPhysician(hospitalPhysicianVo.getHospitalPhysician().getCertificateNumber(), hospitalPhysicianVo.getToken()).toJSONString();
    }

    @RequestMapping("/update")
    public String updateHospitalPhysician(@RequestBody HospitalPhysicianVo hospitalPhysicianVo){
        return hospitalPhysicianService.updateHospitalPhysician(hospitalPhysicianVo.getHospitalPhysician(), hospitalPhysicianVo.getToken()).toJSONString();
    }

    @RequestMapping("/queryByNumber")
    public String  queryHospitalPhysicianByNumber(String certificateNumber){
        return hospitalPhysicianService.queryHospitalPhysicianByNumber(certificateNumber).toJSONString();
    }

    @RequestMapping("/queryByName")
    public String  queryHospitalPhysicianByName(String Name){
        return hospitalPhysicianService.queryHospitalPhysicianByName(Name).toJSONString();
    }
}
