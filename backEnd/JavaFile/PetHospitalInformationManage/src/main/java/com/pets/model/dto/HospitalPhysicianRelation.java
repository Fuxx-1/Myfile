package com.pets.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 15:41
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalPhysicianRelation {
    private String certificateNumber; //医师唯一值
    private int hospitalId; //店面唯一值
}
