package com.pets.mapper;

import com.pets.pojo.HospitalCommodity;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 09:49
 **/
@Repository
public interface HospitalCommodityMapper {
    @Insert("INSERT PETHOSPITALINF.HospitalCommodity(id, commodityName, unit, price, purchasePlace, remarks, reservedValue) VALUES #{id}, #{commodityName}, #{unit}, #{price}, #{purchasePlace}, #{remarks}, #{reservedValue}")
    boolean addHospitalCommodity(HospitalCommodity hospitalCommodity);

    @Delete("DELETE FROM PETHOSPITALINF.HospitalCommodity where id = #{hospitalId} and commodityName = #{Name}")
    boolean delHospitalCommodity(int hospitalId, String Name);

    @Update("UPDATE PETHOSPITALINF.HospitalCommodity set ")
    boolean updateHospitalCommodity(HospitalCommodity hospitalCommodity);

    @Select("")
    HospitalCommodity queryHospitalCommodityByName(int hospitalId, String Name);

    @Select("")
    HospitalCommodity queryHospitalCommodityByHospitalId(int id);
}
