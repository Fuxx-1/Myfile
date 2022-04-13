package com.pets.mapper;

import com.pets.model.dto.PetHospitalInf;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: PetHospitalInformationManage
 * @description: mapper
 * @author: Fuxx-1
 * @create: 2022-03-25 09:25
 **/
@Mapper
public interface PetHospitalInfMapper {
    /**
     *
     * @param petHospitalInf
     * @return
     */
    @Insert("INSERT INTO PETHOSPITALINFMATION.PetHospitalInf" +
            "(name_zh_CN, businessType, hasHospital, staffNumber, storeArea, memberNumber, tel, updateTime, remarks, reservedValue) VALUES" +
            "(#{name_zh_CN}, #{businessType}, #{hasHospital}, #{staffNumber}, #{storeArea}, #{memberNumber}, #{tel}, DATE_FORMAT(NOW(),'%Y-%m-%d'), #{remarks}, #{reservedValue})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    boolean addPetHospitalInf(PetHospitalInf petHospitalInf);

    /**
     *
     * @param id
     * @return
     */
    @Delete("DELETE FROM PETHOSPITALINFMATION.PetHospitalInf " +
            "where id = #{id}; " +
            "DELETE FROM PETHOSPITALINFMATION.HospitalLoc " +
            "where id = #{id};")
    boolean delPetHospitalInf(int id);

    /**
     *
     * @param petHospitalInf
     * @return
     */
    @Update("UPDATE PETHOSPITALINFMATION.PetHospitalInf " +
            "set name_zh_CN = #{name_zh_CN}, businessType = #{businessType}, hasHospital = #{hasHospital}, staffNumber = #{staffNumber}, storeArea = #{storeArea}, memberNumber = #{memberNumber}, tel = #{tel}, remarks = #{remarks}, reservedValue = #{reservedValue}, updateTime = DATE_FORMAT(NOW(),'%Y-%m-%d') " +
            "where id = #{id}")
    boolean updatePetHospitalInf(PetHospitalInf petHospitalInf);

    /**
     *
     * @param start
     * @param limit
     * @return
     */
    @Select("SELECT id, name_zh_CN, businessType, hasHospital, staffNumber, storeArea, memberNumber, tel, remarks, reservedValue " +
            "FROM PETHOSPITALINFMATION.PetHospitalInf where name_zh_CN like '%${SimilarName}%' or 0 = #{hasSimilarName} order by ${field} ${isDesc} limit #{start}, #{limit}")
    List<PetHospitalInf> queryPetHospitalInfByLimit(int start, int limit, String field, String isDesc, String SimilarName, boolean hasSimilarName);

    /**
     *
     * @param name
     * @return
     */
    @Select("SELECT id, name_zh_CN, businessType, hasHospital, staffNumber, storeArea, memberNumber, tel, remarks, reservedValue FROM PETHOSPITALINFMATION.PetHospitalInf where name_zh_CN = #{name}")
    PetHospitalInf queryPetHospitalInfByName(String name);

    @Select("SELECT id, name_zh_CN, businessType, hasHospital, staffNumber, storeArea, memberNumber, tel, remarks, reservedValue FROM PETHOSPITALINFMATION.PetHospitalInf where id = #{id}")
    PetHospitalInf queryPetHospitalInfById(int id);

    @Select("SELECT COUNT(*) FROM PETHOSPITALINFMATION.PetHospitalInf where name_zh_CN like '%${SimilarName}%' or 0 = #{hasSimilarName}")
    int getHospitalCount(String SimilarName, boolean hasSimilarName);
}
