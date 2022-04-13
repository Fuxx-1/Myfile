package com.pets.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-28 18:43
 **/
public interface SummaryService {

    JSONObject getInfCount(boolean isToday, boolean HasHospital, boolean isAll);
}
