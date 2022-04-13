package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.model.dto.PetHospitalInf;

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

    JSONObject queryPetHospitalInf(int limit, int page, String field, boolean isDesc, String SimilarName);

    JSONObject queryPetHospitalInf(String name);

    JSONObject queryPetHospitalInfById(int id);
}
