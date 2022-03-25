package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.PetHospitalInfMapper;
import com.pets.pojo.PetHospitalInf;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:29
 **/
public class PetHospitalInfServiceImpl implements PetHospitalInfService {

    @Autowired
    PetHospitalInfMapper petHospitalInfMapper;

    @Override
    public JSONObject addPetHospitalInf(PetHospitalInf petHospitalInf, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        //判断重复
        if (petHospitalInfMapper.queryPetHospitalInfByName(petHospitalInf.getName_zh_CN()) != null) {
            resp.put("code", -2);
            resp.put("msg", "店名重复");
            return resp;
        }
        //尝试增加
        try {
            resp.put("data", petHospitalInfMapper.addPetHospitalInf(petHospitalInf));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "添加失败");
        }
        return resp;
    }

    @Override
    public JSONObject delPetHospitalInf(int id, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        try {
            petHospitalInfMapper.delPetHospitalInf(id);
            resp.put("code", 0);
            resp.put("data", "成功删除");
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "删除失败");
        }
        return resp;
    }

    @Override
    public JSONObject updatePetHospitalInf(PetHospitalInf petHospitalInf, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        //尝试更新
        try {
            petHospitalInfMapper.updatePetHospitalInf(petHospitalInf);
            resp.put("code", 0);
            resp.put("data", "成功更新");
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "更新失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryPetHospitalInf(int limit, int page) {
        //返回体
        JSONObject resp = new JSONObject();
        //尝试查询
        try {
            resp.put("data", petHospitalInfMapper.queryPetHospitalInfByLimit((page - 1) * limit, limit));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryPetHospitalInf(String name) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", petHospitalInfMapper.queryPetHospitalInfByName(name));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }
}
