package com.pets.model.vo;

import com.pets.model.dto.HospitalPic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-26 14:13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalPicVo implements Serializable {
    private HospitalPic hospitalPic;
    private String token;
}
