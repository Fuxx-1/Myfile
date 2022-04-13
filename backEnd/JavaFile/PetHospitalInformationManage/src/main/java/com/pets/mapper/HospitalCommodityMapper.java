package com.pets.mapper;

import com.pets.model.dto.HospitalCommodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 09:49
 **/
@Mapper
public interface HospitalCommodityMapper {
    @Insert("INSERT INTO PETHOSPITALINFMATION.HospitalCommodity(id, commodityName, unit, price, purchasePlace, remarks, reservedValue) VALUES (#{id}, #{commodityName}, #{unit}, #{price}, #{purchasePlace}, #{remarks}, #{reservedValue})")
    @Options(useGeneratedKeys = true, keyProperty = "commodityId", keyColumn = "commodityId")
    int addHospitalCommodity(HospitalCommodity hospitalCommodity);

    @Delete("DELETE FROM PETHOSPITALINFMATION.HospitalCommodity where commodityId = #{commodityId}")
    boolean delHospitalCommodity(int commodityId);

    @Update("UPDATE PETHOSPITALINFMATION.HospitalCommodity set commodityName = #{commodityName}, unit = #{unit}, price = #{price}, purchasePlace = #{purchasePlace}, remarks = #{remarks}, reservedValue = #{reservedValue} where commodityId = #{commodityId}")
    boolean updateHospitalCommodity(HospitalCommodity hospitalCommodity);

    @Select("SELECT commodityId, id, commodityName, unit, price, purchasePlace, remarks, reservedValue FROM PETHOSPITALINFMATION.HospitalCommodity where id = #{hospitalId} and commodityName = #{Name}")
    HospitalCommodity queryHospitalCommodityByName(int hospitalId, String Name);

    @Select("SELECT commodityId, id, commodityName, unit, price, purchasePlace, remarks, reservedValue FROM PETHOSPITALINFMATION.HospitalCommodity where commodityId = #{commodityId}")
    HospitalCommodity queryHospitalCommodityByCommodityId(int commodityId);

    @Select("SELECT commodityId, id, commodityName, unit, price, purchasePlace, remarks, reservedValue FROM PETHOSPITALINFMATION.HospitalCommodity where id = #{id}")
    List<HospitalCommodity> queryHospitalCommodityByHospitalId(int id);
}
