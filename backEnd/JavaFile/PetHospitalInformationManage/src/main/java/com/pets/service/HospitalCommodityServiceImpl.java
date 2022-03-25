package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.HospitalCommodityMapper;
import com.pets.pojo.HospitalCommodity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:28
 **/
public class HospitalCommodityServiceImpl implements HospitalCommodityService {

    @Autowired
    HospitalCommodityMapper hospitalCommodityMapper;

    @Override
    public JSONObject addHospitalCommodity(HospitalCommodity hospitalCommodity, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        //判断重复
        if (hospitalCommodityMapper.queryHospitalCommodityByName(hospitalCommodity.getId(), hospitalCommodity.getCommodityName()) != null) {
            resp.put("code", -2);
            resp.put("msg", "商品名重复");
            return resp;
        }
        try {
            hospitalCommodityMapper.addHospitalCommodity(hospitalCommodity);
            resp.put("data", "添加成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "添加失败");
        }
        return resp;
    }

    @Override
    public JSONObject delHospitalCommodity(int hospitalId, String Name, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        try {
            hospitalCommodityMapper.delHospitalCommodity(hospitalId, Name);
            resp.put("data", "删除成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "删除失败");
        }
        return resp;
    }

    @Override
    public JSONObject updateHospitalCommodity(HospitalCommodity hospitalCommodity, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        try {
            hospitalCommodityMapper.updateHospitalCommodity(hospitalCommodity);
            resp.put("data", "更新成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "更新失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryHospitalCommodityByName(int hospitalId, String Name) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", hospitalCommodityMapper.queryHospitalCommodityByName(hospitalId, Name));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryHospitalCommodityByHospitalId(int id) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", hospitalCommodityMapper.queryHospitalCommodityByHospitalId(id));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }
}
