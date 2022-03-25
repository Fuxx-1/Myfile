package com.pets.mapper;

import com.pets.pojo.HospitalPic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 09:50
 **/
public interface HospitalPicMapper {
    @Insert("")
    boolean addHospitalPic(HospitalPic hospitalPic);

    @Delete("")
    boolean delHospitalPicByPicId(int picId);

    @Select("")
    List<HospitalPic> queryHospitalPicByHospitalId(int id);
}
