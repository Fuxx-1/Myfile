package com.pets.model.vo;

import com.pets.model.dto.HospitalLoc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-26 14:24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalLocVo implements Serializable {
    private HospitalLoc hospitalLoc;
    private String token;
}
