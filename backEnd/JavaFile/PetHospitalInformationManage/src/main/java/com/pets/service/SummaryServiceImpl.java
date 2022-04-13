package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.SummaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-28 18:44
 **/
@Service
public class SummaryServiceImpl implements SummaryService {
    @Autowired
    SummaryMapper summaryMapper;

    @Override
    public JSONObject getInfCount(boolean isToday, boolean HasHospital, boolean isAll) {
        JSONObject resp = new JSONObject();
        resp.put("total", summaryMapper.getInfCount(isToday, HasHospital, isAll));
        return resp;
    }
}
