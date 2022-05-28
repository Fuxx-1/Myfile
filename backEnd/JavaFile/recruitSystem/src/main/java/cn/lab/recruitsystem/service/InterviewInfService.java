package cn.lab.recruitsystem.service;

import cn.lab.recruitsystem.Model.vo.FieldVo;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:05
 */
public interface InterviewInfService {

    /**
     * 增加用户面试信息
     * @param userid 用户id
     * @return 是否成功
     */
    JSONObject addInterview(String userid);

    /**
     * 删除用户面试信息（SuperAdmin）
     * @param userid 用户id
     * @return 是否成功
     */
    JSONObject delInterview(String userid);


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
    JSONObject updateInterview(String userid, Integer times, String interview, Integer attitude, Integer ability,
                               String remarks, Boolean ispass, String interviewer, Boolean final_ispass);

    /**
     * 以当前状态发送邮件
     * @param userid 用户id
     * @return 是否成功
     */
    JSONObject sendEmail(String userid, String contact);

    /**
     * 获取面试信息
     * @param userid 用户id
     * @return 用户面试信息（部分）
     */
    JSONObject getInterviewInf(String userid);

    /**
     * 查询用户面试状态，用于管理员
     * @param similarName 相似搜素
     * @param fields      排序项
     * @param page 第几页
     * @param limit 结束
     * @return 返回查询结果
     */
    JSONObject queryInterviewInf(String similarName, List<FieldVo> fields, Integer page, Integer limit);
}
