package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import com.pets.pojo.HospitalCommodity;
import com.pets.service.HospitalCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 19:20
 **/
@Controller
public class HospitalCommodityController {

    @Autowired
    HospitalCommodityService hospitalCommodityService;

    public String addHospitalCommodity(HospitalCommodity hospitalCommodity, String token) {
        return hospitalCommodityService.addHospitalCommodity(hospitalCommodity, token).toJSONString();
    }

    public String delHospitalCommodity(int hospitalId, String Name, String token) {
        return hospitalCommodityService.delHospitalCommodity(hospitalId, Name, token).toJSONString();
    }

    public String updateHospitalCommodity(HospitalCommodity hospitalCommodity, String token) {
        return hospitalCommodityService.updateHospitalCommodity(hospitalCommodity, token).toJSONString();
    }

    public String queryHospitalCommodityByName(int hospitalId, String Name) {
        return hospitalCommodityService.queryHospitalCommodityByName(hospitalId, Name).toJSONString();
    }

    public String queryHospitalCommodityByHospitalId(int id) {
        return hospitalCommodityService.queryHospitalCommodityByHospitalId(id).toJSONString();
    }
}
