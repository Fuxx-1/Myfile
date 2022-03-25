package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.pojo.HospitalCommodity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:22
 **/
public interface HospitalCommodityService {
    JSONObject addHospitalCommodity(HospitalCommodity hospitalCommodity, String token);

    JSONObject delHospitalCommodity(int hospitalId, String Name, String token);

    JSONObject updateHospitalCommodity(HospitalCommodity hospitalCommodity, String token);

    JSONObject queryHospitalCommodityByName(int hospitalId, String Name);

    JSONObject queryHospitalCommodityByHospitalId(int id);
}
