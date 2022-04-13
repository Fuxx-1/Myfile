package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import com.pets.model.vo.HospitalPhysicianRelationVo;
import com.pets.service.HospitalPhysicianRelationService;
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
@RequestMapping("/PhysicianRelation")
@ResponseBody
@CrossOrigin
public class HospitalPhysicianRelationController {

    @Autowired
    HospitalPhysicianRelationService hospitalPhysicianRelationService;

    @RequestMapping("/add")
    public String addHospitalPhysicianRelation(@RequestBody HospitalPhysicianRelationVo hospitalPhysicianRelationVo){
        return hospitalPhysicianRelationService.addHospitalPhysicianRelation(hospitalPhysicianRelationVo.getHospitalPhysicianRelation().getHospitalId(), hospitalPhysicianRelationVo.getHospitalPhysicianRelation().getCertificateNumber(), hospitalPhysicianRelationVo.getToken()).toJSONString();
    }

    @RequestMapping("/delete")
    public String delHospitalPhysicianRelation(@RequestBody HospitalPhysicianRelationVo hospitalPhysicianRelationVo){
        return hospitalPhysicianRelationService.delHospitalPhysicianRelation(hospitalPhysicianRelationVo.getHospitalPhysicianRelation().getHospitalId(), hospitalPhysicianRelationVo.getHospitalPhysicianRelation().getCertificateNumber(), hospitalPhysicianRelationVo.getToken()).toJSONString();
    }

    @RequestMapping("/queryByHospitalId")
    public String queryHospitalPhysicianRelation(int hospitalId){
        return hospitalPhysicianRelationService.queryHospitalPhysicianRelation(hospitalId).toJSONString();
    }
}
