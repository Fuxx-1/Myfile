package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.HospitalPhysicianMapper;
import com.pets.pojo.HospitalPhysician;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:29
 **/
public class HospitalPhysicianServiceImpl implements HospitalPhysicianService {

    @Autowired
    HospitalPhysicianMapper hospitalPhysicianMapper;

    @Override
    public JSONObject addHospitalPhysician(HospitalPhysician hospitalPhysician, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        //判断重复
        if (hospitalPhysicianMapper.queryHospitalPhysicianByCertificateNumber(hospitalPhysician.getCertificateNumber()) != null) {
            resp.put("code", -2);
            resp.put("msg", "医师重复");
            return resp;
        }
        try {
            hospitalPhysicianMapper.addHospitalPhysician(hospitalPhysician);
            resp.put("data", "添加成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "添加失败");
        }
        return resp;
    }

    @Override
    public JSONObject delHospitalPhysician(String certificateNumber, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        try {
            hospitalPhysicianMapper.delHospitalPhysician(certificateNumber);
            resp.put("data", "删除成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "删除失败");
        }
        return resp;
    }

    @Override
    public JSONObject updateHospitalPhysician(HospitalPhysician hospitalPhysician, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        try {
            hospitalPhysicianMapper.updateHospitalPhysician(hospitalPhysician);
            resp.put("data", "更新成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "更新失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryHospitalPhysicianByName(String certificateNumber) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", hospitalPhysicianMapper.queryHospitalPhysicianByCertificateNumber(certificateNumber));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "更新失败");
        }
        return resp;
    }
}
