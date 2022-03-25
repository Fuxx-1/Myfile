package com.pets.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalPhysician {
    private int id; //店面唯一值
    private int physicianId; //auto_increment值，医师唯一值
    private String physicianName; //姓名
    private boolean ismale; //性别
    private String idNumber; //身份证号
    private String telephone; //联系电话
    private String certificateNumber; //医师证号
    private String specialty; //专长
    private String title; //职称
    private String education; //学历
    private String graduationSchool; //毕业学校
    private String remarks; //备注
    private String reservedValue; //预留值
}
