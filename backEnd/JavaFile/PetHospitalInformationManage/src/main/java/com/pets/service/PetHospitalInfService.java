package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.pojo.PetHospitalInf;
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
 * @create: 2022-03-25 10:23
 **/
public interface PetHospitalInfService {

    JSONObject addPetHospitalInf(PetHospitalInf petHospitalInf, String token);

    JSONObject delPetHospitalInf(int id, String token);

    JSONObject updatePetHospitalInf(PetHospitalInf petHospitalInf, String token);

    JSONObject queryPetHospitalInf(int limit, int page);

    JSONObject queryPetHospitalInf(String name);
}
