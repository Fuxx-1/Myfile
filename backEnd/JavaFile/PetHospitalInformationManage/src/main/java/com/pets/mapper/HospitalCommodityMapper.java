package com.pets.mapper;

import com.pets.pojo.HospitalCommodity;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.apache.ibatis.annotations.*;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 09:49
 **/
@Mapper
public interface HospitalCommodityMapper {
    @Insert("")
    boolean addHospitalCommodity(HospitalCommodity hospitalCommodity);

    @Delete("")
    boolean delHospitalCommodity(int id);

    @Update("")
    boolean updateHospitalCommodity(HospitalCommodity hospitalCommodity);

    @Select("")
    HospitalCommodity queryHospitalCommodityByName(String name);

    @Select("")
    HospitalCommodity queryHospitalCommodityByHospitalId(int id);
}
