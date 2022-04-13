package com.pets.mapper;

import com.pets.model.dto.HospitalLoc;
import com.pets.model.vo.queryByLocVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-25 09:45
 **/
@Mapper
public interface HospitalLocMapper {

    @Insert("INSERT INTO PETHOSPITALINFMATION.HospitalLoc" +
            "(id, latitude, longitude, location, remarks, reservedValue) VALUES " +
            "(#{id}, #{latitude}, #{longitude}, #{location}, #{remarks}, #{reservedValue})")
    boolean addHospitalLoc(HospitalLoc hospitalLoc);

    @Delete("DELETE FROM PETHOSPITALINFMATION.HospitalLoc " +
            "where id = #{id}")
    boolean delHospitalLoc(int id);

    @Update("UPDATE PETHOSPITALINFMATION.HospitalLoc " +
            "set latitude = #{latitude}, longitude = #{longitude}, location = #{location}, " +
            "remarks = #{remarks}, reservedValue = #{reservedValue} " +
            "where id = #{id}")
    boolean updateHospitalLoc(HospitalLoc hospitalLoc);

    @Select("SELECT id, latitude, longitude, location, remarks, reservedValue " +
            "FROM PETHOSPITALINFMATION.HospitalLoc " +
            "where id = #{id}")
    HospitalLoc queryHospitalLoc(int id);

    @Select("SELECT HospitalLoc.id, ROUND(ST_DISTANCE_SPHERE(POINT(#{longitude}, #{latitude}), POINT(HospitalLoc.longitude, HospitalLoc.latitude))) dis, enforcesheet.rectificateFrequence, namesheet.name_zh_CN " +
            "FROM HospitalLoc " +
            "INNER JOIN (SELECT id, name_zh_CN FROM PETHOSPITALINFMATION.PetHospitalInf GROUP BY id) AS namesheet ON HospitalLoc.id = namesheet.id " +
            "LEFT JOIN (SELECT hospitalId, COUNT(situationid) rectificateFrequence FROM PETHOSPITALINFMATION.situation WHERE isCompleted = 0 GROUP BY hospitalId) AS enforcesheet ON HospitalLoc.id = enforcesheet.hospitalId " +
            "WHERE 0 = #{hasEnforce} OR enforcesheet.rectificateFrequence > 0 " +
            "ORDER BY dis ${isDesc} limit #{start}, #{limit}")
    List<Map<String, Object>> queryHospitalLocByMyLoc(boolean hasEnforce, float longitude, float latitude, String isDesc, int start, int limit);

    @Select("SELECT COUNT(*) FROM PETHOSPITALINFMATION.HospitalLoc")
    int getLocCount();
}
