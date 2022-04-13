package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.HospitalPicMapper;
import com.pets.model.dto.HospitalPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:29
 **/
@Service
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
            resp.put("data", hospitalPic.getPicid());
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "添加失败");
        }
        return resp;
    }

    @Override
    public JSONObject delHospitalPic(int picId, String token) {
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
            if (hospitalPicMapper.queryHospitalPicByPicId(picId) == null) {
                resp.put("code", -2);
                resp.put("msg", "图片不存在");
                return resp;
            }
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
            resp.put("msg", "查询失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryHospitalPicByPicId(int picId) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            HospitalPic pic = hospitalPicMapper.queryHospitalPicByPicId(picId);
            if (pic == null) {
                resp.put("code", -1);
                resp.put("msg", "图片不存在");
                return resp;
            }
            resp.put("data", pic);
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryHospitalPicByHospitalByCertificateNumber(String certificateNumber) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", hospitalPicMapper.queryHospitalPicByHospitalCertificateNumber(certificateNumber));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryHospitalPicByHospitalBySituationId(int SituationId) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", hospitalPicMapper.queryHospitalPicBySituationId(SituationId));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryHospitalPicByHospitalByCommodityId(int CommodityId) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", hospitalPicMapper.queryHospitalPicByCommodityid(CommodityId));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }
}
