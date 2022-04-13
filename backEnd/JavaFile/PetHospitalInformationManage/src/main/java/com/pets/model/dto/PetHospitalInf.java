package com.pets.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetHospitalInf {
    private int id; //auto_increment值，店面唯一值
    private String name_zh_CN; //中文店面名称
    private String businessType; //经营范围
    private Boolean hasHospital; //有医疗设施
    private int staffNumber = -1; //工作人员人数
    private float storeArea = -1; //店面面积
    private int memberNumber = -1; //该店面会员数
    private String tel; //店面联系电话
    private String userId; //创建用户
//    private Date updateTime = new Date(2022-1-1); // 更新时间
    private String remarks; //店面备注
    private String reservedValue; //预留值
}