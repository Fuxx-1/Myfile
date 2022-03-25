package com.pets.mapper;

import com.pets.pojo.HospitalPhysician;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 09:49
 **/
public interface HospitalPhysicianMapper {

    @Insert("")
    boolean addHospitalPhysician(HospitalPhysician hospitalPhysician);

    @Delete("")
    boolean delHospitalPhysician(String certificateNumber);

    @Update("")
    boolean updateHospitalPhysician(HospitalPhysician hospitalPhysician);

    @Select("")
    HospitalPhysician queryHospitalPhysicianByCertificateNumber(String certificateNumber);
}
