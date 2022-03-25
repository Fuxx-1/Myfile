package com.pets.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.Store;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetHospitalInf {
    private int id; //auto_increment值，店面唯一值
    private String name_zh_CN; //中文店面名称
    private boolean hasHospital; //有医疗设施
    private int staffNumber; //工作人员人数
    private float storeArea; //店面面积
    private int memberNumber; //该店面会员数
    private String tel; //店面联系电话
    private String remarks; //店面备注
    private String reservedValue; //预留值
}