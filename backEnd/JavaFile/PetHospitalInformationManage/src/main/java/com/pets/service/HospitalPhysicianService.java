package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.pojo.HospitalPhysician;
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
public interface HospitalPhysicianService {

    JSONObject addHospitalPhysician(HospitalPhysician hospitalPhysician, String token);

    JSONObject delHospitalPhysician(String certificateNumber, String token);

    JSONObject updateHospitalPhysician(HospitalPhysician hospitalPhysician, String token);

    JSONObject  queryHospitalPhysicianByName(String certificateNumber);
}
