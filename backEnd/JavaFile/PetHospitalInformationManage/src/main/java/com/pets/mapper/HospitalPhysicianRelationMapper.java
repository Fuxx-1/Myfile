package com.pets.mapper;

import com.pets.model.dto.HospitalPhysicianRelation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 16:53
 **/
@Mapper
public interface HospitalPhysicianRelationMapper {
    @Insert("INSERT INTO PETHOSPITALINFMATION.HospitalPhysicianRelation(certificateNumber, hospitalId) VALUES (#{certificateNumber}, #{hospitalId})")
    boolean addHospitalPhysicianRelation(int hospitalId, String certificateNumber);

    @Delete("DELETE FROM PETHOSPITALINFMATION.HospitalPhysicianRelation where certificateNumber = #{certificateNumber} and hospitalId = #{hospitalId}")
    boolean delHospitalPhysicianRelation(int hospitalId, String certificateNumber);

    @Select("SELECT certificateNumber, hospitalId FROM PETHOSPITALINFMATION.HospitalPhysicianRelation where certificateNumber = #{certificateNumber} and hospitalId = #{hospitalId}")
    HospitalPhysicianRelation queryHospitalPhysicianRelation(int hospitalId, String certificateNumber);

    @Select("SELECT certificateNumber, hospitalId FROM PETHOSPITALINFMATION.HospitalPhysicianRelation where hospitalId = #{hospitalId}")
    List<HospitalPhysicianRelation> queryHospitalPhysicianRelationByHospitalId(int hospitalId);
}
