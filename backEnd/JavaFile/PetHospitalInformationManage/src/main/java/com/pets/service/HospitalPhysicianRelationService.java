package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 16:59
 **/
public interface HospitalPhysicianRelationService {

    JSONObject addHospitalPhysicianRelation(int hospitalId, String certificateNumber, String token);

    JSONObject delHospitalPhysicianRelation(int hospitalId, String certificateNumber, String token);

    JSONObject queryHospitalPhysicianRelation(int hospitalId);
}
