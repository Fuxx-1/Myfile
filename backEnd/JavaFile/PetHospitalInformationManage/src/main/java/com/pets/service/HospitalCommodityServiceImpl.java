package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.HospitalCommodityMapper;
import com.pets.model.dto.HospitalCommodity;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:28
 **/
@Service
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
        try {
            //判断重复
            if (hospitalCommodityMapper.queryHospitalCommodityByName(hospitalCommodity.getId(), hospitalCommodity.getCommodityName()) != null) {
                resp.put("code", -2);
                resp.put("msg", "商品名重复");
                return resp;
            }
            hospitalCommodityMapper.addHospitalCommodity(hospitalCommodity);
            resp.put("data", hospitalCommodity.getCommodityId());
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "添加失败");
        }
        return resp;
    }

    @Override
    public JSONObject delHospitalCommodity(int commodityId, String token) {
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
            if (hospitalCommodityMapper.queryHospitalCommodityByCommodityId(commodityId) == null) {
                resp.put("code", -2);
                resp.put("msg", "商品不存在");
                return resp;
            }
            hospitalCommodityMapper.delHospitalCommodity(commodityId);
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
        //查询并补全null值参数
        HospitalCommodity hospitalCommodityOrigin;
        try {
            //获取原值
            hospitalCommodityOrigin = hospitalCommodityMapper.queryHospitalCommodityByCommodityId(hospitalCommodity.getCommodityId());
            if (hospitalCommodity.equals(hospitalCommodityOrigin)) {
                resp.put("code", -1);
                resp.put("msg", "无需更新");
                return resp;
            }
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "更新失败");
            return resp;
        }
        if (hospitalCommodityOrigin == null) {
            resp.put("code", -2);
            resp.put("msg", "该商品不存在");
            return resp;
        } else {
            //null值补全（补以原值）
            if (hospitalCommodity.getCommodityName() == null || hospitalCommodity.getCommodityName().length() == 0) {
                hospitalCommodity.setCommodityName(hospitalCommodityOrigin.getCommodityName());
            }
            if (hospitalCommodity.getUnit() == null || hospitalCommodity.getUnit().length() == 0) {
                hospitalCommodity.setUnit(hospitalCommodityOrigin.getUnit());
            }
            if (hospitalCommodity.getPrice() == -1) {
                hospitalCommodity.setPrice(hospitalCommodityOrigin.getPrice());
            }
            if (hospitalCommodity.getPurchasePlace() == null || hospitalCommodity.getPurchasePlace().length() == 0) {
                hospitalCommodity.setPurchasePlace(hospitalCommodityOrigin.getPurchasePlace());
            }
            if (hospitalCommodity.getRemarks() == null || hospitalCommodity.getRemarks().length() == 0) {
                hospitalCommodity.setRemarks(hospitalCommodityOrigin.getRemarks());
            }
            if (hospitalCommodity.getReservedValue() == null || hospitalCommodity.getReservedValue().length() == 0) {
                hospitalCommodity.setReservedValue(hospitalCommodityOrigin.getReservedValue());
            }
        }
        try {
            hospitalCommodityMapper.updateHospitalCommodity(hospitalCommodity);
            resp.put("data", "更新成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "更新失败");
            return resp;
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
