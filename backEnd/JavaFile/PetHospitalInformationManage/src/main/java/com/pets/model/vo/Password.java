package com.pets.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-26 13:14
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Password implements Serializable {
    private String password;
    private String token;
}
