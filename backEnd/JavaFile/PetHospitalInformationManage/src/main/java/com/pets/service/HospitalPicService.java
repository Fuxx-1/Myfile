package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.pojo.HospitalPic;
import org.springframework.stereotype.Service;

@Service
/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:23
 **/
public interface HospitalPicService {

    JSONObject addHospitalPic(HospitalPic hospitalPic, String token);

    JSONObject delHospitalPic(int picId, int type, String token);

    JSONObject queryHospitalPicByHospitalId(int id);
}
