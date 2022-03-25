package com.pets.mapper;

import com.pets.pojo.HospitalLoc;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 09:45
 **/
@Repository
public interface HospitalLocMapper {

    @Insert("")
    boolean addHospitalLoc(HospitalLoc hospitalLoc);

    @Delete("")
    boolean delHospitalLoc(int id);

    @Update("")
    boolean updateHospitalLoc(HospitalLoc hospitalLoc);

    @Select("")
    HospitalLoc queryHospitalLoc(int id);
}
