package com.pets.mapper;

import com.pets.pojo.PetHospitalInf;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: PetHospitalInformationManage
 * @description: mapper
 * @author: Fuxx-1
 * @create: 2022-03-25 09:25
 **/
@Repository
public interface PetHospitalInfMapper {
    /**
     *
     * @param petHospitalInf
     * @return
     */
    @Insert("")
    @Options(useGeneratedKeys = true,keyProperty = "recordId")
    int addPetHospitalInf(PetHospitalInf petHospitalInf);

    /**
     *
     * @param id
     * @return
     */
    @Delete("")
    boolean delPetHospitalInf(int id);

    /**
     *
     * @param petHospitalInf
     * @return
     */
    @Update("")
    boolean updatePetHospitalInf(PetHospitalInf petHospitalInf);

    /**
     *
     * @param start
     * @param limit
     * @return
     */
    @Select("")
    List<PetHospitalInf> queryPetHospitalInfByLimit(int start, int limit);

    /**
     *
     * @param name
     * @return
     */
    @Select("")
    PetHospitalInf queryPetHospitalInfByName(String name);
}
