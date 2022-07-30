package cn.lab.recruitsystem.mapper;

import cn.lab.recruitsystem.Model.dto.InterviewInf;
import cn.lab.recruitsystem.Model.vo.InterviewInfVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:05
 */
@Mapper
public interface InterviewInfMapper {

    /**
     *初始化面试
     * @param userid 需要初始化的userid
     * @return 是否初始化成功
     */
    @Insert("insert into `interview` (userid, create_time, update_time) " +
            "values (#{userid}, now(), now());")
    Boolean addInterview(String userid);

    /**
     * 刪除面试（SuperAdmin）
     * @param userid 要刪除的面试的的用戶id
     * @return 是否刪除成功
     */
    @Delete("delete from `interview` " +
            "where userid = #{userid};")
    Boolean delInterview(String userid);

    /**
     * 更新面试信息（评价）
     * @param userid 要更新的用户id
     * @param times 第几面试
     * @param interview 评价
     * @param attitude 态度分
     * @param ability 能力分
     * @param remarks 备注
     * @param ispass 是否通过
     * @param interviewer 面试官
     * @param final_ispass 最终是否通过
     * @return 是否修改成功
     */
    @Update("update `interview` set " +
            "`${times}_interview` = #{interview}, `${times}_attitude` = #{attitude}, `${times}_ability` = #{ability}, " +
            "`${times}_remarks` = #{remarks}, `${times}_ispass` = #{ispass}, `${times}_interviewer` = #{interviewer}, " +
            "final_ispass = #{final_ispass} " +
            "where userid = #{userid};")
    Boolean updateinterview(String userid, String times, String interview, Integer attitude, Integer ability,
                            String remarks, Boolean ispass, String interviewer, Boolean final_ispass);

    /**
     * 更改邮件发送状态
     * @param userid 用户id
     * @param is_send 是否发送
     * @return 是否修改成功
     */
    @Update("update `interview` set " +
            "is_send = #{is_send} " +
            "where userid = #{userid};")
    Boolean updateEmail(String userid, Boolean is_send);

    /**
     * 更新登录时间
     * @param userid 更新用户id
     * @return 登录时间是否成功更改
     */
    @Update("update `interview` set " +
            "update_time = now() " +
            "where userid = #{userid};")
    Boolean updateTime(String userid);

    /**
     * 获取用户通过情况，用于用户查询面试状态
     * @param userid 用户id
     * @return 面试信息
     */
    @Select("select " +
            "first_ispass, first_interviewer, second_ispass, second_interviewer, third_ispass, third_interviewer, " +
            "final_ispass, is_send, create_time, update_time " +
            "from `interview` " +
            "where userid = #{userid}")
    InterviewInf getUserInf(String userid);

    /**
     * 查询用户面试状态，用于管理员
     * @param similarName 相似搜素
     * @param field1 排序项A-第一优先
     * @param field2 排序项B-第二优先
     * @param isDesc 是否降序
     * @param start 开始
     * @param limit 结束
     * @return 返回查询结果
     */
    @Select("select " +
            "interview.userid, namesheet.name, namesheet.wish, " +
            "interview.first_interview, interview.first_attitude, interview.first_ability, interview.first_remarks, " +
            "interview.first_ispass, interview.first_interviewer, " +
            "interview.second_interview, interview.second_attitude, interview.second_ability, interview.second_remarks, " +
            "interview.second_ispass, interview.second_interviewer, " +
            "interview.third_interview, interview.third_attitude, interview.third_ability, interview.third_remarks, " +
            "interview.third_ispass, interview.third_interviewer, " +
            "interview.final_ispass, interview.is_send, interview.create_time, interview.update_time " +
            "from `interview` " +
            "left join (select userid, name, wish from `user` group by userid) as namesheet on interview.userid = namesheet.userid " +
            "where namesheet.name like '%${similarName}%' and (#{wish} is null or namesheet.wish = #{wish}) order by ${ground} limit #{start}, #{limit}")
    List<InterviewInfVo> queryUserInf(String similarName, String ground, Integer wish, Integer start, Integer limit);

    /**
     * 查询用户面试状态，用于管理员
     * @param similarName 相似搜素
     * @param field1 排序项A-第一优先
     * @param field2 排序项B-第二优先
     * @param isDesc 是否降序
     * @param start 开始
     * @param limit 结束
     * @return 返回查询结果
     */
    @Select("select " +
            "count(*) " +
            "from `interview` " +
            "left join (select userid, name, wish from `user` group by userid) as namesheet on interview.userid = namesheet.userid " +
            "where namesheet.name like '%${similarName}%' and (#{wish} is null or namesheet.wish = #{wish})")
    Integer queryUserInfTotal(String similarName, Integer wish);
}
