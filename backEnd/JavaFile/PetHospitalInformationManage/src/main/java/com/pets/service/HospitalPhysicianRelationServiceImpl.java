package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.HospitalPhysicianRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 16:59
 **/
@Service
public class HospitalPhysicianRelationServiceImpl implements HospitalPhysicianRelationService{

    @Autowired
    HospitalPhysicianRelationMapper hospitalPhysicianRelationMapper;

    @Override
    public JSONObject addHospitalPhysicianRelation(int hospitalId, String certificateNumber, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        try {
            //判断重复
            if (hospitalPhysicianRelationMapper.queryHospitalPhysicianRelation(hospitalId, certificateNumber) != null) {
                resp.put("code", -2);
                resp.put("msg", "关系重复");
                return resp;
            }
            hospitalPhysicianRelationMapper.addHospitalPhysicianRelation(hospitalId, certificateNumber);
            resp.put("data", "添加成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "添加失败");
        }
        return resp;
    }

    @Override
    public JSONObject delHospitalPhysicianRelation(int hospitalId, String certificateNumber, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        try {
            //判断存在
            if (hospitalPhysicianRelationMapper.queryHospitalPhysicianRelation(hospitalId, certificateNumber) == null) {
                resp.put("code", -2);
                resp.put("msg", "关系不存在");
                return resp;
            }
            hospitalPhysicianRelationMapper.delHospitalPhysicianRelation(hospitalId, certificateNumber);
            resp.put("data", "删除成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "删除失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryHospitalPhysicianRelation(int hospitalId) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", hospitalPhysicianRelationMapper.queryHospitalPhysicianRelationByHospitalId(hospitalId));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }
}
