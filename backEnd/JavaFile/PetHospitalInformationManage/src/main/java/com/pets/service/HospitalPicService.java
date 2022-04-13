package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.model.dto.HospitalPic;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:23
 **/
public interface HospitalPicService {

    JSONObject addHospitalPic(HospitalPic hospitalPic, String token);

    JSONObject delHospitalPic(int picId, String token);

    JSONObject queryHospitalPicByHospitalId(int id);

    JSONObject queryHospitalPicByPicId(int id);

    JSONObject queryHospitalPicByHospitalByCertificateNumber(String certificateNumber);

    JSONObject queryHospitalPicByHospitalBySituationId(int SituationId);

    JSONObject queryHospitalPicByHospitalByCommodityId(int CommodityId);
}
