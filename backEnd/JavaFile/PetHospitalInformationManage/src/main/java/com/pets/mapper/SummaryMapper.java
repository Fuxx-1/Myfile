package com.pets.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-28 18:44
 **/
@Mapper
public interface SummaryMapper {

    @Select("SELECT COUNT(*) FROM PETHOSPITALINFMATION.PetHospitalInf where hasHospital = #{hasHospital} or (1 = #{isToday} and updateTime = DATE_FORMAT(NOW(),'%Y-%m-%d')) or 1 = #{isAll};")
    int getInfCount(boolean isToday, boolean hasHospital, boolean isAll);
}
