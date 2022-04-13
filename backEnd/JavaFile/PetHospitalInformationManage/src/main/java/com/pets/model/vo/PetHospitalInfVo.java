package com.pets.model.vo;

import com.pets.model.dto.PetHospitalInf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-26 13:47
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetHospitalInfVo implements Serializable {
    private PetHospitalInf petHospitalInf;
    private String token;
}
