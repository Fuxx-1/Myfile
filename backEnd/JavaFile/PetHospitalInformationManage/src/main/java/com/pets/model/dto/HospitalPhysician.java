package com.pets.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalPhysician {
    private String physicianName; //姓名
    private Boolean ismale; //性别
    private String tel; //联系电话
    private String certificateNumber; //医师证号，唯一值
    private String idCardNumber; //身份证
    private String specialty; //专长
    private String title; //职称
    private String education; //学历
    private String graduationSchool; //毕业学校
    private String remarks; //备注
    private String reservedValue; //预留值
}
