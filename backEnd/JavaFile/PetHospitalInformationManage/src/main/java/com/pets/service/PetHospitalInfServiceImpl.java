package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.PetHospitalInfMapper;
import com.pets.model.dto.HospitalLoc;
import com.pets.model.dto.PetHospitalInf;
import com.pets.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:29
 **/
@Service
public class PetHospitalInfServiceImpl implements PetHospitalInfService {

    @Autowired
    PetHospitalInfMapper petHospitalInfMapper;

    /**
     * 增加主信息
     * @param petHospitalInf 要增加的主信息
     * @param token 认证
     * @return 是否增加成功
     */
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
        //填入修改时间
//        petHospitalInf.setUpdateTime(TimeUtil.getTime());
        //尝试增加
        try {
            //判断重复
            if (petHospitalInfMapper.queryPetHospitalInfByName(petHospitalInf.getName_zh_CN()) != null) {
                resp.put("code", -2);
                resp.put("msg", "店名重复");
                return resp;
            }
            petHospitalInfMapper.addPetHospitalInf(petHospitalInf);
            resp.put("data", petHospitalInf.getId());
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "添加失败");
        }
        return resp;
    }

    /**
     * 删除主信息
     * @param id 要删除的id
     * @param token 认证
     * @return 是否删除成功
     */
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
            //判断存在
            if (petHospitalInfMapper.queryPetHospitalInfById(id) == null) {
                resp.put("code", -2);
                resp.put("msg", "店铺不存在");
                return resp;
            }
            petHospitalInfMapper.delPetHospitalInf(id);
            resp.put("code", 0);
            resp.put("data", "成功删除");
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "删除失败");
        }
        return resp;
    }

    /**
     * 更新主信息
     * @param petHospitalInf 要更新的主信息，按id更新
     * @param token 认证
     * @return 是否更新成功
     */
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
        //判重
        if (petHospitalInf.getName_zh_CN() != null && petHospitalInf.getName_zh_CN().length() > 0 && petHospitalInfMapper.queryPetHospitalInfByName(petHospitalInf.getName_zh_CN()) != null) {
            resp.put("code", -2);
            resp.put("msg", "店名重复");
            return resp;
        }
        //查询并补全null值参数
        PetHospitalInf petHospitalInfOrigin;
        try {
            //获取原值
            petHospitalInfOrigin = petHospitalInfMapper.queryPetHospitalInfById(petHospitalInf.getId());
            if (petHospitalInf.equals(petHospitalInfOrigin)) {
                resp.put("code", -1);
                resp.put("msg", "无需更新");
                return resp;
            }
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "更新失败");
            return resp;
        }
        if (petHospitalInfOrigin == null) {
            resp.put("code", -2);
            resp.put("msg", "该店铺不存在，请先添加");
            return resp;
        } else {
            //null值补全（补以原值）
            if (petHospitalInf.getName_zh_CN() == null || petHospitalInf.getName_zh_CN().length() == 0) {
                petHospitalInf.setName_zh_CN(petHospitalInfOrigin.getName_zh_CN());
            }
            if (petHospitalInf.getBusinessType() == null || petHospitalInf.getBusinessType().length() == 0) {
                petHospitalInf.setBusinessType(petHospitalInfOrigin.getBusinessType());
            }
            if (petHospitalInf.getHasHospital() == null) {
                petHospitalInf.setHasHospital(petHospitalInfOrigin.getHasHospital());
            }
            if (petHospitalInf.getStaffNumber() == -1) {
                petHospitalInf.setStaffNumber(petHospitalInfOrigin.getStaffNumber());
            }
            if (petHospitalInf.getStoreArea() == -1) {
                petHospitalInf.setStoreArea(petHospitalInfOrigin.getStoreArea());
            }
            if (petHospitalInf.getMemberNumber() == -1) {
                petHospitalInf.setMemberNumber(petHospitalInfOrigin.getMemberNumber());
            }
            if (petHospitalInf.getTel() == null || petHospitalInf.getTel().length() == 0) {
                petHospitalInf.setTel(petHospitalInfOrigin.getTel());
            }
            if (petHospitalInf.getRemarks() == null || petHospitalInf.getRemarks().length() == 0) {
                petHospitalInf.setRemarks(petHospitalInfOrigin.getRemarks());
            }
            if (petHospitalInf.getReservedValue() == null || petHospitalInf.getReservedValue().length() == 0) {
                petHospitalInf.setReservedValue(petHospitalInfOrigin.getReservedValue());
            }
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

    /**
     * 查询主信息，允许SimilarName
     * @param limit 每页多少数据
     * @param page 第几页
     * @param field 排序字段
     * @param isDesc 是否降序
     * @param SimilarName 关键字
     * @return 查询结果
     */
    @Override
    public JSONObject queryPetHospitalInf(int limit, int page, String field, boolean isDesc, String SimilarName) {
        //返回体
        JSONObject resp = new JSONObject();
        if (SimilarName == null || SimilarName.length() == 0) {
            SimilarName = "";
        }
        //尝试查询
        try {
            List<PetHospitalInf> hospitalInfs = petHospitalInfMapper.queryPetHospitalInfByLimit((page - 1) * limit, limit, field == null || field.length() <= 0 ? "id" : field, isDesc ? "desc" : "asc", SimilarName, SimilarName != null || SimilarName.length() > 0);
            Map mainInfo = new HashMap<>();
            mainInfo.put("totalSize", petHospitalInfMapper.getHospitalCount(SimilarName, SimilarName != null || SimilarName.length() > 0));
            mainInfo.put("info", hospitalInfs);
            resp.put("data", mainInfo);
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

    @Override
    public JSONObject queryPetHospitalInfById(int id) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", petHospitalInfMapper.queryPetHospitalInfById(id));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }
}
