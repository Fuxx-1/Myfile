package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.model.dto.HospitalCommodity;


/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:22
 **/
public interface HospitalCommodityService {
    JSONObject addHospitalCommodity(HospitalCommodity hospitalCommodity, String token);

    JSONObject delHospitalCommodity(int commodityId, String token);

    JSONObject updateHospitalCommodity(HospitalCommodity hospitalCommodity, String token);

    JSONObject queryHospitalCommodityByName(int hospitalId, String Name);

    JSONObject queryHospitalCommodityByHospitalId(int id);
}
