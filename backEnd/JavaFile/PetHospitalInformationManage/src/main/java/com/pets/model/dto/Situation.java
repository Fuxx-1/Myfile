package com.pets.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * program: PetHospitalInformationManage
 * description:
 * create: 2022-04-09 15:26
 * @author Fuxx-1
 * @value situationid 执法情况唯一值
 * @value createid
 * @value createTime
 * @value enforceInf
 * @value rectificateFrequence
 * @value rectificateid
 * @value rectificateTime
 * @value isCompleted
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Situation {
    private int situationid;
    private int hospitalId;
    private String createid;
    private String createTime;
    private String enforceInf;
    private String remarks; //备注
    private String reservedValue; //预留值
    private int rectificateFrequence;
    private String rectificateid;
    private String rectificateTime;
    private Boolean isCompleted;
}
