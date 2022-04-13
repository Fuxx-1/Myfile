package com.pets.mapper;

import com.pets.model.dto.HospitalPic;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 09:50
 **/
public interface HospitalPicMapper {
    @Insert("INSERT INTO PETHOSPITALINFMATION.HospitalPic" +
            "(id, certificateNumber, commodityid, situationid, pic, type) VALUES " +
            "(#{id}, #{certificateNumber}, #{commodityid}, #{situationid}, #{pic}, #{type})")
    @Options(useGeneratedKeys = true, keyProperty = "picid", keyColumn = "picid")
    boolean addHospitalPic(HospitalPic hospitalPic);

    @Delete("DELETE FROM PETHOSPITALINFMATION.HospitalPic " +
            "where picid = #{picId}")
    boolean delHospitalPicByPicId(int picId);

    @Select("SELECT pic FROM PETHOSPITALINFMATION.HospitalPic " +
            "where picid = #{picid}")
    HospitalPic queryHospitalPicByPicId(int picid);

    @Select("SELECT picid, type FROM PETHOSPITALINFMATION.HospitalPic " +
            "where id = #{id} and type > 0")
    List<Map<String, Object>> queryHospitalPicByHospitalId(int id);

    @Select("SELECT picid FROM PETHOSPITALINFMATION.HospitalPic " +
            "where certificateNumber = #{certificateNumber}")
    List<Integer> queryHospitalPicByHospitalCertificateNumber(String certificateNumber);

    @Select("SELECT picid FROM PETHOSPITALINFMATION.HospitalPic " +
            "where situationid = #{situationid}")
    List<Integer> queryHospitalPicBySituationId(int situationid);

    @Select("SELECT picid FROM PETHOSPITALINFMATION.HospitalPic " +
            "where commodityid = #{commodityid}")
    List<Integer> queryHospitalPicByCommodityid(int commodityid);
}
