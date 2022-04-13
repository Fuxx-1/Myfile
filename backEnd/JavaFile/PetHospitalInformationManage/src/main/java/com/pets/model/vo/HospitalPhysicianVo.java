package com.pets.model.vo;

import com.pets.model.dto.HospitalPhysician;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-26 14:21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalPhysicianVo implements Serializable {
    private HospitalPhysician hospitalPhysician;
    private String token;
}
