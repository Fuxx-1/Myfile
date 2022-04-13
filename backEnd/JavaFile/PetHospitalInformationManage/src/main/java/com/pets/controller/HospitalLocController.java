package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import com.pets.model.dto.HospitalLoc;
import com.pets.model.vo.HospitalLocVo;
import com.pets.service.HospitalLocService;
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
@RequestMapping("/Loc")
@ResponseBody
@CrossOrigin
public class HospitalLocController {

    @Autowired
    HospitalLocService hospitalLocService;

    @RequestMapping("/add")
    public String addHospitalLoc(@RequestBody HospitalLocVo hospitalLocVo) {
        return hospitalLocService.addHospitalLoc(hospitalLocVo.getHospitalLoc(), hospitalLocVo.getToken()).toJSONString();
    }

    @RequestMapping("/delete")
    public String delHospitalLoc(@RequestBody HospitalLocVo hospitalLocVo) {
        return hospitalLocService.delHospitalLoc(hospitalLocVo.getHospitalLoc().getId(), hospitalLocVo.getToken()).toJSONString();
    }

    @RequestMapping("/update")
    public String updateHospitalLoc(@RequestBody HospitalLocVo hospitalLocVo) {
        return hospitalLocService.updateHospitalLoc(hospitalLocVo.getHospitalLoc(), hospitalLocVo.getToken()).toJSONString();
    }

    @RequestMapping("/query")
    public String queryHospitalLoc(int id) {
        return hospitalLocService.queryHospitalLoc(id).toJSONString();
    }

    @RequestMapping("queryByLoc")
    public String queryHospitalLocByMyLoc(boolean hasEnforce, float longitude, float latitude, boolean isDesc, int page, int limit) {
        return hospitalLocService.queryHospitalLocByMyLoc(hasEnforce, longitude, latitude, isDesc, page, limit).toJSONString();
    }
}
