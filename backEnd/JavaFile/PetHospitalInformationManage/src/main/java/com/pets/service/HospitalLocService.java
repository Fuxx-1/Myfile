package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.model.dto.HospitalLoc;

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

    JSONObject queryHospitalLocByMyLoc(boolean hasEnforce, float longitude, float latitude, boolean isDesc, int page, int limit);
}
