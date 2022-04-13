package com.pets.controller;

import com.pets.model.dto.HospitalCommodity;
import com.pets.model.vo.HospitalCommodityVo;
import com.pets.service.HospitalCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 19:20
 **/
@Controller
@RequestMapping("/Commodity")
@ResponseBody
@CrossOrigin
public class HospitalCommodityController {

    @Autowired
    HospitalCommodityService hospitalCommodityService;

    @PostMapping("/add")
    public String addHospitalCommodity(@RequestBody HospitalCommodityVo hospitalCommodityVo) {
        return hospitalCommodityService.addHospitalCommodity(hospitalCommodityVo.getHospitalCommodity(), hospitalCommodityVo.getToken()).toJSONString();
    }

    @RequestMapping("/delete")
    public String delHospitalCommodity(@RequestBody HospitalCommodityVo hospitalCommodityVo) {
        return hospitalCommodityService.delHospitalCommodity(hospitalCommodityVo.getHospitalCommodity().getCommodityId(), hospitalCommodityVo.getToken()).toJSONString();
    }

    @RequestMapping("/update")
    public String updateHospitalCommodity(@RequestBody HospitalCommodityVo hospitalCommodityVo) {
        return hospitalCommodityService.updateHospitalCommodity(hospitalCommodityVo.getHospitalCommodity(), hospitalCommodityVo.getToken()).toJSONString();
    }

    @RequestMapping("/queryByName")
    public String queryHospitalCommodityByName(int hospitalId, String Name) {
        return hospitalCommodityService.queryHospitalCommodityByName(hospitalId, Name).toJSONString();
    }

    @RequestMapping("/queryById")
    public String queryHospitalCommodityByHospitalId(int hospitalId) {
        return hospitalCommodityService.queryHospitalCommodityByHospitalId(hospitalId).toJSONString();
    }
}
