package com.pets.mapper;

import com.pets.pojo.PetHospitalInf;
import org.apache.ibatis.annotations.*;

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
    @Insert("")
    boolean addPetHospitalInf(PetHospitalInf petHospitalInf);

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
    PetHospitalInf queryPetHospitalInf(int start, int limit);

    /**
     *
     * @param name
     * @return
     */
    @Select("")
    PetHospitalInf queryPetHospitalInf(String name);
}
