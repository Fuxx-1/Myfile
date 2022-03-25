package com.pets.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalLoc {
    private int id; //店面唯一值
    private float latitude; //纬度
    private float longitude; //经度
    private String location; //文字地址
    private String remarks; //备注
    private String reservedValue; //预留值
}
