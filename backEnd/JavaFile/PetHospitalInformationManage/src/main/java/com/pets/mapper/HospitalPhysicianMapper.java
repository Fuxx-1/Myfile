package com.pets.mapper;

import com.pets.model.dto.HospitalPhysician;
import org.apache.ibatis.annotations.*;

@Mapper
/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 09:49
 **/
public interface HospitalPhysicianMapper {

    @Insert("INSERT INTO PETHOSPITALINFMATION.HospitalPhysician" +
            "(certificateNumber, idCardNumber, physicianName, ismale, tel, specialty, title, education, graduationSchool, remarks, reservedValue) VALUES" +
            "(#{certificateNumber}, #{idCardNumber}, #{physicianName}, #{ismale}, #{tel}, #{specialty}, #{title}, #{education}, #{graduationSchool}, #{remarks}, #{reservedValue})")
    boolean addHospitalPhysician(HospitalPhysician hospitalPhysician);

    @Delete("DELETE FROM PETHOSPITALINFMATION.HospitalPhysician " +
            "where certificateNumber = #{certificateNumber}")
    boolean delHospitalPhysician(String certificateNumber);

    @Update("UPDATE PETHOSPITALINFMATION.HospitalPhysician SET " +
            "idCardNumber = #{idCardNumber}, physicianName = #{physicianName}, ismale = #{ismale}, tel = #{tel}, specialty = #{specialty}, " +
            "title = #{title}, education = #{education}, graduationSchool = #{graduationSchool}, remarks = #{remarks}, " +
            "reservedValue = #{reservedValue} " +
            "where certificateNumber = #{certificateNumber}")
    boolean updateHospitalPhysician(HospitalPhysician hospitalPhysician);

    @Select("SELECT certificateNumber, idCardNumber, physicianName, ismale, tel, specialty, title, education, graduationSchool, remarks, reservedValue FROM PETHOSPITALINFMATION.HospitalPhysician where certificateNumber = #{certificateNumber}")
    HospitalPhysician queryHospitalPhysicianByCertificateNumber(String certificateNumber);

    @Select("SELECT certificateNumber, idCardNumber, physicianName, ismale, tel, specialty, title, education, graduationSchool, remarks, reservedValue FROM PETHOSPITALINFMATION.HospitalPhysician where physicianName = #{Name}")
    HospitalPhysician queryHospitalPhysicianByName(String Name);
}
