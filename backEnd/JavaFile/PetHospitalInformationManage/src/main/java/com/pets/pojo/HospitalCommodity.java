package com.pets.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalCommodity {
    private int id; //店面唯一值
    private int commodityId; //auto_increment值，商品唯一值
    private String commodityName; //商品名
    private String unit; //单位
    private float price; //单价
    private String purchasePlace; //进货地
    private String remarks; //备注
    private String reservedValue; //预留值
}
