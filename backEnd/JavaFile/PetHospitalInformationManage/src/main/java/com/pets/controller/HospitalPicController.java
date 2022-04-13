package com.pets.controller;

import com.pets.model.dto.HospitalPic;
import com.pets.model.vo.HospitalPicVo;
import com.pets.model.vo.PetHospitalInfVo;
import com.pets.service.HospitalPicService;
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
 * @create: 2022-03-25 19:22
 **/
@Controller
@RequestMapping("/Pic")
@ResponseBody
@CrossOrigin
public class HospitalPicController {

    @Autowired
    HospitalPicService hospitalPicService;

    @RequestMapping("/add")
    public String addHospitalPic(@RequestBody HospitalPicVo hospitalPicVo) {
        return hospitalPicService.addHospitalPic(hospitalPicVo.getHospitalPic(), hospitalPicVo.getToken()).toJSONString();
    }

    @RequestMapping("/delete")
    public String delHospitalPic(@RequestBody HospitalPicVo hospitalPicVo){
        return hospitalPicService.delHospitalPic(hospitalPicVo.getHospitalPic().getPicid(), hospitalPicVo.getToken()).toJSONString();
    }

    @RequestMapping("/queryByHospitalId")
    public String queryHospitalPicByHospitalId(int hospitalId){
        return hospitalPicService.queryHospitalPicByHospitalId(hospitalId).toJSONString();
    }

    @RequestMapping("/queryByPicId")
    public String queryHospitalPicByPicId(int picId){
        return hospitalPicService.queryHospitalPicByPicId(picId).toJSONString();
    }

    @RequestMapping("/queryByCertificateNumber")
    public String queryHospitalPicByCertificateNumber(String certificateNumber){
        return hospitalPicService.queryHospitalPicByHospitalByCertificateNumber(certificateNumber).toJSONString();
    }

    @RequestMapping("/queryBySituationId")
    public String queryHospitalPicBySituationId(int SituationId){
        return hospitalPicService.queryHospitalPicByHospitalBySituationId(SituationId).toJSONString();
    }

    @RequestMapping("/queryByCommodityId")
    public String queryHospitalPicByCommodityId(int CommodityId){
        return hospitalPicService.queryHospitalPicByHospitalByCommodityId(CommodityId).toJSONString();
    }
}
