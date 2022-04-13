package com.pets.model.vo;

import com.pets.model.dto.HospitalCommodity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-26 14:32
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalCommodityVo implements Serializable {
    private HospitalCommodity hospitalCommodity;
    private String token;
}
