package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.model.dto.PetHospitalInf;
import com.pets.model.dto.Situation;

/**
 * program: PetHospitalInformationManage
 * description:
 * @author Fuxx-1
 * create: 2022-04-09 15:50
 **/
public interface SituationService {

    JSONObject addSituation(Situation situation);

    JSONObject completeSituation(int situationid, String openid);

    JSONObject updateRectificate(int situationid, String openid);

    JSONObject updateInf(Situation situation);

    JSONObject querySituation(int hospitalId);
}
