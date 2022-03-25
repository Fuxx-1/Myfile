package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.HospitalPicMapper;
import com.pets.pojo.HospitalPic;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:29
 **/
public class HospitalPicServiceImpl implements HospitalPicService {

    @Autowired
    HospitalPicMapper hospitalPicMapper;

    @Override
    public JSONObject addHospitalPic(HospitalPic hospitalPic, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        try {
            hospitalPicMapper.addHospitalPic(hospitalPic);
            resp.put("code", 0);
            resp.put("data", "成功添加");
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "添加失败");
        }
        return resp;
    }

    @Override
    public JSONObject delHospitalPic(int picId, int type, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        try {
            hospitalPicMapper.delHospitalPicByPicId(picId);
            resp.put("data", "删除成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "删除失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryHospitalPicByHospitalId(int id) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", hospitalPicMapper.queryHospitalPicByHospitalId(id));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "添加失败");
        }
        return resp;
    }
}
