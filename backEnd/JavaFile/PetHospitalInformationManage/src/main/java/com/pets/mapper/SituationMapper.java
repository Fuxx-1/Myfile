package com.pets.mapper;

import com.pets.model.dto.Situation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * program: PetHospitalInformationManage
 * description:
 * @author Fuxx-1
 * create: 2022-04-09 15:38
 **/
@Mapper
public interface SituationMapper {

    /**
     * 增加执法记录
     * @param situation 要增加的值
     * @return 是否成功 及 situationid
     */
    @Insert("INSERT INTO PETHOSPITALINFMATION.situation" +
            "(hospitalId, createid, createTime, enforceInf, remarks, reservedValue) VALUES" +
            "(#{hospitalId}, #{createid}, DATE_FORMAT(NOW(),'%Y-%m-%d'), #{enforceInf}, #{remarks}, #{reservedValue})")
    @Options(useGeneratedKeys = true, keyProperty = "situationid", keyColumn = "situationid")
    boolean addSituation(Situation situation);

    /**
     * 完成整改
     * @param situationid
     * @param rectificateid
     * @return
     */
    @Update("UPDATE PETHOSPITALINFMATION.situation SET " +
            "isCompleted = 1, rectificateFrequence = rectificateFrequence + 1, rectificateid = #{rectificateid}, rectificateTime = DATE_FORMAT(NOW(),'%Y-%m-%d') " +
            "where situationid = #{situationid}")
    boolean completeSituation(int situationid, String rectificateid);

    /**
     * 未完成整改
     * @param situationid
     * @param rectificateid
     * @return
     */
    @Update("UPDATE PETHOSPITALINFMATION.situation SET " +
            "rectificateFrequence = rectificateFrequence + 1, rectificateid = #{rectificateid}, rectificateTime = DATE_FORMAT(NOW(),'%Y-%m-%d') " +
            "where situationid = #{situationid} and isCompleted = 0")
    boolean updateRectificate(int situationid, String rectificateid);

    /**
     * 更新信息
     * @param situationid
     * @param enforceInf
     * @return
     */
    @Update("UPDATE PETHOSPITALINFMATION.situation SET " +
            "enforceInf = #{enforceInf}, remarks = #{remarks}, reservedValue = #{reservedValue} " +
            "where situationid = #{situationid} and isCompleted = 0")
    boolean updateInf(Situation situation);

    /**
     * hospitalId查询
     * @param hospitalId
     * @return
     */
    @Select("SELECT situationid, hospitalId, createid, createTime, enforceInf, rectificateFrequence, rectificateid, rectificateTime, remarks, reservedValue " +
            "FROM PETHOSPITALINFMATION.situation " +
            "where hospitalId = #{hospitalId} and isCompleted = 0")
    List<Situation> querySituation(int hospitalId);

    /**
     * situationid查询
     * @param situationid
     * @return
     */
    @Select("SELECT hospitalId, createid, createTime, enforceInf, rectificateFrequence, rectificateid, rectificateTime, remarks, reservedValue " +
            "FROM PETHOSPITALINFMATION.situation " +
            "where situationid = #{situationid} and isCompleted = 0")
    Situation querySituationBySituationid(int situationid);
}
