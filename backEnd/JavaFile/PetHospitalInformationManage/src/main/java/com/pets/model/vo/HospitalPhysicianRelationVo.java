package com.pets.model.vo;

import com.pets.model.dto.HospitalPhysicianRelation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-26 14:17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalPhysicianRelationVo implements Serializable {
    private HospitalPhysicianRelation hospitalPhysicianRelation;
    private String token;
}
