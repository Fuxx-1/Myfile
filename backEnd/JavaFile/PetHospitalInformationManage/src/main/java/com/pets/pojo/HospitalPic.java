package com.pets.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalPic {
    private int id; //店面唯一值
    private int physicianId; //医师唯一值
    private int commodityId; //商品唯一值
    private int picid; //auto_increment值，图片唯一值
    private Byte[] pic; //图片
    private boolean type;//图片类型，1为内景，2为外景，3为营业执照，4为医师照片，5为商品照片
}
