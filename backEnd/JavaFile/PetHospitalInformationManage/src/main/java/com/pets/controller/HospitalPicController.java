package com.pets.controller;

import com.alibaba.fastjson.JSONObject;
import com.pets.pojo.HospitalPic;
import com.pets.service.HospitalPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 19:22
 **/
@Controller
public class HospitalPicController {

    @Autowired
    HospitalPicService hospitalPicService;

    public String addHospitalPic(HospitalPic hospitalPic, String token) {
        return hospitalPicService.addHospitalPic(hospitalPic, token).toJSONString();
    }

    public String delHospitalPic(int picId, int type, String token){
        return hospitalPicService.delHospitalPic(picId, type, token).toJSONString();
    }

    public String queryHospitalPicByHospitalId(int hospitalId){
        return hospitalPicService.queryHospitalPicByHospitalId(hospitalId).toJSONString();
    }
}
