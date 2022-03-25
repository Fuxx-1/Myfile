package com.pets.mapper;

import com.pets.pojo.HospitalPhysicianRelation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 16:53
 **/
@Repository
public interface HospitalPhysicianRelationMapper {
    @Insert("")
    boolean addHospitalPhysicianRelation(int hospitalId, String certificateNumber);

    @Delete("")
    boolean delHospitalPhysicianRelation(int hospitalId, String certificateNumber);

    @Select("")
    HospitalPhysicianRelation queryHospitalPhysicianRelation(int hospitalId, String certificateNumber);

    @Select("")
    HospitalPhysicianRelation queryHospitalPhysicianRelationByHospitalId(int hospitalId);
}
