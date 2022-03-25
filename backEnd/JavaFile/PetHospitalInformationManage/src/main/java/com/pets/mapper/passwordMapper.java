package com.pets.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 11:12
 **/
@Repository
public interface passwordMapper {
    @Select("")
    String querypassword();
}
