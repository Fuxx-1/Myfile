package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.HospitalLocMapper;
import com.pets.mapper.SummaryMapper;
import com.pets.model.dto.HospitalCommodity;
import com.pets.model.dto.HospitalLoc;
import com.pets.model.dto.PetHospitalInf;
import com.pets.model.vo.queryByLocVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:28
 **/
@Service
public class HospitalLocServiceImpl implements HospitalLocService {

    @Autowired
    HospitalLocMapper hospitalLocMapper;

    @Override
    public JSONObject addHospitalLoc(HospitalLoc hospitalLoc, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        try {
            hospitalLocMapper.addHospitalLoc(hospitalLoc);
            resp.put("data", "添加成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "添加失败");
        }
        return resp;
    }

    @Override
    public JSONObject delHospitalLoc(int id, String token) {
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
            if (hospitalLocMapper.queryHospitalLoc(id) == null) {
                resp.put("code", -2);
                resp.put("msg", "该店铺不存在位置");
                return resp;
            }
            hospitalLocMapper.delHospitalLoc(id);
            resp.put("data", "删除成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "删除失败");
        }
        return resp;
    }

    @Override
    public JSONObject updateHospitalLoc(HospitalLoc hospitalLoc, String token) {
        //返回体
        JSONObject resp = new JSONObject();
        //判断权限
        if (com.main.util.JWTUtil.verifyToken(token) != 0) {
            resp.put("code", -1);
            resp.put("msg", "未登录或登录过期");
            return resp;
        }
        //查询并补全null值参数
        HospitalLoc hospitalLocOrigin;
        try {
            //获取原值
            hospitalLocOrigin = hospitalLocMapper.queryHospitalLoc(hospitalLoc.getId());
            if (hospitalLoc.equals(hospitalLocOrigin)) {
                resp.put("code", -1);
                resp.put("msg", "无需更新");
                return resp;
            }
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "更新失败");
            return resp;
        }
        if (hospitalLocOrigin == null) {
            resp.put("code", -2);
            resp.put("msg", "该店铺不存在位置，请先添加");
            return resp;
        } else {
            //null值补全（补以原值）
            if (hospitalLoc.getLatitude() == -600) {
                hospitalLoc.setLatitude(hospitalLocOrigin.getLatitude());
            }
            if (hospitalLoc.getLongitude() == -600) {
                hospitalLocOrigin.setLongitude(hospitalLocOrigin.getLongitude());
            }
            if (hospitalLoc.getLocation() == null || hospitalLoc.getLocation().length() == 0) {
                hospitalLoc.setLocation(hospitalLocOrigin.getLocation());
            }
            if (hospitalLoc.getRemarks() == null || hospitalLoc.getRemarks().length() == 0) {
                hospitalLoc.setRemarks(hospitalLocOrigin.getRemarks());
            }
            if (hospitalLoc.getReservedValue() == null || hospitalLoc.getReservedValue().length() == 0) {
                hospitalLoc.setReservedValue(hospitalLocOrigin.getReservedValue());
            }
        }
        try {
            hospitalLocMapper.updateHospitalLoc(hospitalLoc);
            resp.put("data", "更新成功");
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "更新失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryHospitalLoc(int id) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", hospitalLocMapper.queryHospitalLoc(id));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryHospitalLocByMyLoc(boolean hasEnforce, float longitude, float latitude, boolean isDesc, int page, int limit) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            List<Map<String, Object>> Locs = hospitalLocMapper.queryHospitalLocByMyLoc(hasEnforce, longitude, latitude, isDesc ? "desc" : "asc", (page - 1) * limit, limit);
            Map mainInfo = new HashMap<>();
            mainInfo.put("totalSize", hospitalLocMapper.getLocCount());
            mainInfo.put("info", Locs);
            resp.put("data", mainInfo);
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }
}
