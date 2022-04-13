package com.pets.service;

import com.alibaba.fastjson.JSONObject;
import com.pets.mapper.HospitalPhysicianMapper;
import com.pets.model.dto.HospitalLoc;
import com.pets.model.dto.HospitalPhysician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 10:29
 **/
@Service
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
        try {
            //判断重复
            if (hospitalPhysicianMapper.queryHospitalPhysicianByCertificateNumber(hospitalPhysician.getCertificateNumber()) != null) {
                resp.put("code", -2);
                resp.put("msg", "医师重复");
                return resp;
            }
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
            //判断存在
            if (hospitalPhysicianMapper.queryHospitalPhysicianByCertificateNumber(certificateNumber) == null) {
                resp.put("code", -2);
                resp.put("msg", "医师不存在");
                return resp;
            }
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
        //查询并补全null值参数
        HospitalPhysician hospitalPhysicianOrigin;
        try {
            //获取原值
            hospitalPhysicianOrigin = hospitalPhysicianMapper.queryHospitalPhysicianByCertificateNumber(hospitalPhysician.getCertificateNumber());
            if (hospitalPhysician.equals(hospitalPhysicianOrigin)) {
                resp.put("code", -1);
                resp.put("msg", "无需更新");
                return resp;
            }
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "更新失败");
            return resp;
        }
        if (hospitalPhysicianOrigin == null) {
            resp.put("code", -2);
            resp.put("msg", "医师不存在");
            return resp;
        } else {
            //null值补全（补以原值）
            if (hospitalPhysician.getIdCardNumber() == null || hospitalPhysician.getIdCardNumber().length() == 0) {
                hospitalPhysician.setIdCardNumber(hospitalPhysicianOrigin.getIdCardNumber());
            }
            if (hospitalPhysician.getPhysicianName() == null || hospitalPhysician.getPhysicianName().length() == 0) {
                hospitalPhysician.setPhysicianName(hospitalPhysicianOrigin.getPhysicianName());
            }
            if (hospitalPhysician.getIsmale() == null) {
                hospitalPhysician.setIsmale(hospitalPhysicianOrigin.getIsmale());
            }
            if (hospitalPhysician.getTel() == null || hospitalPhysician.getTel().length() == 0) {
                hospitalPhysician.setTel(hospitalPhysicianOrigin.getTel());
            }
            if (hospitalPhysician.getSpecialty() == null || hospitalPhysician.getSpecialty().length() == 0) {
                hospitalPhysician.setSpecialty(hospitalPhysicianOrigin.getSpecialty());
            }
            if (hospitalPhysician.getTitle() == null || hospitalPhysician.getTitle().length() == 0) {
                hospitalPhysician.setTitle(hospitalPhysicianOrigin.getTitle());
            }
            if (hospitalPhysician.getEducation() == null || hospitalPhysician.getEducation().length() == 0) {
                hospitalPhysician.setEducation(hospitalPhysicianOrigin.getEducation());
            }
            if (hospitalPhysician.getGraduationSchool() == null || hospitalPhysician.getGraduationSchool().length() == 0) {
                hospitalPhysician.setGraduationSchool(hospitalPhysicianOrigin.getGraduationSchool());
            }
            if (hospitalPhysician.getRemarks() == null || hospitalPhysician.getRemarks().length() == 0) {
                hospitalPhysician.setRemarks(hospitalPhysicianOrigin.getRemarks());
            }
            if (hospitalPhysician.getReservedValue() == null || hospitalPhysician.getReservedValue().length() == 0) {
                hospitalPhysician.setReservedValue(hospitalPhysicianOrigin.getReservedValue());
            }
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
    public JSONObject queryHospitalPhysicianByNumber(String certificateNumber) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", hospitalPhysicianMapper.queryHospitalPhysicianByCertificateNumber(certificateNumber));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }

    @Override
    public JSONObject queryHospitalPhysicianByName(String Name) {
        //返回体
        JSONObject resp = new JSONObject();
        try {
            resp.put("data", hospitalPhysicianMapper.queryHospitalPhysicianByName(Name));
            resp.put("code", 0);
        } catch (Exception e) {
            resp.put("code", -1);
            resp.put("msg", "查询失败");
        }
        return resp;
    }
}
