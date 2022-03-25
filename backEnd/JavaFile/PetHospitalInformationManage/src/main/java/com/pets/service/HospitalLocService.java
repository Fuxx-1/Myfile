package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.pojo.HospitalLoc;
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
public interface HospitalLocService {
    JSONObject addHospitalLoc(HospitalLoc hospitalLoc, String token);

    JSONObject delHospitalLoc(int id, String token);

    JSONObject updateHospitalLoc(HospitalLoc hospitalLoc, String token);

    JSONObject queryHospitalLoc(int id);
}
