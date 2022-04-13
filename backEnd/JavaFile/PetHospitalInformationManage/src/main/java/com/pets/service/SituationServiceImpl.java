package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.SituationMapper;
import com.pets.model.dto.PetHospitalInf;
import com.pets.model.dto.Situation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * program: PetHospitalInformationManage
 * description:
 *
 * @author Fuxx-1
 * create: 2022-04-09 15:50
 **/
@Service
public class SituationServiceImpl implements SituationService {

    @Autowired
    SituationMapper situationMapper;

    @Override
    public JSONObject addSituation(Situation situation) {
        //返回体
        JSONObject resp = new JSONObject();
        situation.setCreateid("该功能未完成");
        //尝试增加
        try {
            situationMapper.addSituation(situation);
            resp.put("data", situation.getSituationid());
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "添加失败");
        }
        return resp;
    }

    @Override
    public JSONObject completeSituation(int situationid, String openid) {
        //返回体
        JSONObject resp = new JSONObject();
        openid = "该功能未完成";
        //尝试更改
        try {
            situationMapper.completeSituation(situationid, openid);
            resp.put("msg", "完成");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "失败");
        }
        return resp;
    }

    @Override
    public JSONObject updateRectificate(int situationid, String openid) {
        //返回体
        JSONObject resp = new JSONObject();
        openid = "该功能未完成";
        //尝试更改
        try {
            situationMapper.updateRectificate(situationid, openid);
            resp.put("msg", "完成");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "失败");
        }
        return resp;
    }

    @Override
    public JSONObject updateInf(Situation situation) {
        //返回体
        JSONObject resp = new JSONObject();
        Situation situationOrigin;
        try {
            //获取原值
            situationOrigin = situationMapper.querySituationBySituationid(situation.getSituationid());
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "更新失败");
            return resp;
        }
        if (situationOrigin == null) {
            resp.put("code", -2);
            resp.put("msg", "该记录不存在，请先添加");
            return resp;
        } else {
            //null值补全（补以原值）
            if (situation.getEnforceInf() == null || situation.getEnforceInf().length() == 0) {
                situation.setEnforceInf(situationOrigin.getEnforceInf());
            }
            if (situation.getRemarks() == null || situation.getRemarks().length() == 0) {
                situation.setRemarks(situationOrigin.getRemarks());
            }
            if (situation.getReservedValue() == null || situation.getReservedValue().length() == 0) {
                situation.setReservedValue(situationOrigin.getReservedValue());
            }
        }
        //尝试更新
        try {
            situationMapper.updateInf(situation);
            resp.put("code", 0);
            resp.put("data", "成功更新");
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "更新失败");
        }
        return resp;
    }

    @Override
    public JSONObject querySituation(int hospitalId) {
        //返回体
        JSONObject resp = new JSONObject();
        //尝试查询
        try {
            resp.put("data", situationMapper.querySituation(hospitalId));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }
}
