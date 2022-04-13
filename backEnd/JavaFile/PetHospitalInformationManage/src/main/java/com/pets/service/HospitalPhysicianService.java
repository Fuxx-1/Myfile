package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.model.dto.HospitalPhysician;

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

    JSONObject  queryHospitalPhysicianByNumber(String certificateNumber);

    JSONObject  queryHospitalPhysicianByName(String Name);
}
