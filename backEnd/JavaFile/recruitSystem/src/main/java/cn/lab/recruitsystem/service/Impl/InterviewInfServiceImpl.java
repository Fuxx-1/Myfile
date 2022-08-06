package cn.lab.recruitsystem.service.Impl;

import cn.lab.recruitsystem.Model.dto.InterviewResult;
import cn.lab.recruitsystem.Model.dto.NotEvaluate;
import cn.lab.recruitsystem.Model.dto.ResultEmail;
import cn.lab.recruitsystem.Model.dto.User;
import cn.lab.recruitsystem.Model.vo.FieldVo;
import cn.lab.recruitsystem.Util.MailUtil;
import cn.lab.recruitsystem.Util.ReturnUtil;
import cn.lab.recruitsystem.mapper.InterviewInfMapper;
import cn.lab.recruitsystem.mapper.UserMapper;
import cn.lab.recruitsystem.service.InterviewInfService;
import com.alibaba.fastjson.JSONObject;
import freemarker.template.Template;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:07
 */
@Service
public class InterviewInfServiceImpl implements InterviewInfService {

    @Resource
    MailUtil mailUtil;

    @Resource
    UserMapper userMapper;

    @Resource
    InterviewInfMapper interviewInfMapper;

    @Resource
    FreeMarkerConfigurer freeMarkerConfigurer;


    /**
     * 增加用户面试信息
     *
     * @param userid 用户id
     * @return 是否成功
     */
    @Override
    public JSONObject addInterview(String userid) {
        try {
            if (userMapper.getUserInf(userid).getIs_sign()) {
                // 该用户已签到
                if (interviewInfMapper.getUserInf(userid) == null) {
                    // 该用户无面试
                    interviewInfMapper.addInterview(userid);
                    return ReturnUtil.returnObj("初始化完成", 0, null);
                } else {
                    // 该用户已有面试
                    return ReturnUtil.returnObj("该用户已有面试", 6, null);
                }
            } else {
                // 该用户未签到
                return ReturnUtil.returnObj("该用户未签到", 5, null);
            }
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.InterviewInfServiceImpl.addInterview").warning(e.toString());
            return ReturnUtil.returnObj("增加失败", -5, null);
        }
    }

    /**
     * 删除用户面试信息（SuperAdmin）
     *
     * @param userid 用户id
     * @return 是否成功
     */
    @Override
    public JSONObject delInterview(String userid) {
        try {
            interviewInfMapper.delInterview(userid);
            return ReturnUtil.returnObj("删除成功", 0, null);
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.InterviewInfServiceImpl.delInterview").warning(e.toString());
            return ReturnUtil.returnObj("删除失败", -5, null);
        }
    }

    /**
     * 更新面试信息（评价）
     *
     * @param userid       要更新的用户id
     * @param times        第几面试
     * @param interview    评价
     * @param attitude     态度分
     * @param ability      能力分
     * @param remarks      备注
     * @param ispass       是否通过
     * @param interviewer  面试官
     * @param final_ispass 最终是否通过
     * @return 是否修改成功
     */
    @Override
    public JSONObject updateInterview(String userid, Integer times, String interview, Integer attitude, Integer ability, String remarks, Boolean ispass, String interviewer, Boolean final_ispass) {
        String timeValue = "";
        switch (times) {
            case 1:
                timeValue = "first";
                break;
            case 2:
                timeValue = "second";
                break;
            case 3:
                timeValue = "third";
                break;
            default:
                break;
        }
        // Integer型 times 转 String型
        try {
            interviewInfMapper.updateinterview(userid, timeValue, interview, attitude, ability, remarks, ispass, userMapper.getUserInf(interviewer).getName(), final_ispass);
            interviewInfMapper.updateTime(userid);
            return ReturnUtil.returnObj("更新成功", 0, null);
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.InterviewInfServiceImpl.updateInterview").warning(e.toString());
            return ReturnUtil.returnObj("更新失败", -4, null);
        }
    }

    /**
     * 以当前状态发送邮件
     *
     * @param userid 用户id
     * @return 是否成功
     */
    @Override
    public JSONObject sendEmail(String userid, String contact) {
        try {
            InterviewResult interviewInf = interviewInfMapper.getUserInf(userid);
            String chosenEmail = interviewInf.getFinal_ispass() ? "success.html" : "fail.html";
            // 获取面试结果
            if (interviewInf.getIs_send() != null) {
                // 邮件已发送
                return ReturnUtil.returnObj("该用户结果邮件已发送", 7, null);
            }
            User user = userMapper.getUserInf(userid);
            // 获取email
            ResultEmail resultEmail = new ResultEmail(user.getName(), contact);
            // 发送邮件
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(chosenEmail);
            String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, new HashMap<String, Object>() {{
                put("resultEmail", resultEmail);
            }});
            mailUtil.sendHtmlMail(user.getEmail(), "Union Lab纳新结果通知", templateHtml);
            interviewInfMapper.updateEmail(userid, true);
            interviewInfMapper.updateTime(userid);
            return ReturnUtil.returnObj("发送成功", 0, null);
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.InterviewInfServiceImpl.sendEmail").warning(e.toString());
            return ReturnUtil.returnObj("发送失败", -5, null);
        }
    }

    /**
     * 获取面试信息
     *
     * @param userid 用户id
     * @return 用户面试信息（部分）
     */
    @Override
    public JSONObject getInterviewInf(String userid) {
        try {
            System.out.println(userid);
            System.out.println(interviewInfMapper.getUserInf(userid).hideInterviewer());
            return ReturnUtil.returnObj("查询成功", 0, interviewInfMapper.getUserInf(userid).hideInterviewer());
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.InterviewInfServiceImpl.getInterviewInf").warning(e.toString());
            return ReturnUtil.returnObj("查询失败", -6, null);
        }
    }

    /**
     * 查询用户面试状态，用于管理员
     *
     * @param similarName 相似搜素
     * @param fields      排序项
     * @param page        第几页
     * @param limit       结束
     * @return 返回查询结果
     */
    @Override
    public JSONObject queryInterviewInf(String similarName, List<FieldVo> fields, Integer wish, Integer page, Integer limit) {
        StringBuffer ground = new StringBuffer();
        // 排序
        for (FieldVo field : fields) {
            field.setField(field.getField().replaceAll("[^a-zA-Z_]", ""));
            ground.append("`").append(field.getField()).append("`").append(field.getIsDesc() ? " DESC" : " ");
        }
        try {
            return ReturnUtil.returnObj("查询成功", 0, new HashMap<String, Object>(2) {{
                put("info", interviewInfMapper.queryUserInf(similarName, ground.toString(), wish, limit * (page - 1), limit * page));
                put("listSize", interviewInfMapper.queryUserInfTotal(similarName, wish));
            }});
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.InterviewInfServiceImpl.queryInterviewInf").warning(e.toString());
            return ReturnUtil.returnObj("查询失败", -6, null);
        }
    }

    /**
     * 获取评价的相关信息
     * @return 评价的相关信息
     */
    @Override
    public JSONObject getEvaluate() {
        try {
            return ReturnUtil.returnObj("查询成功", 0, new HashMap<String, Object>() {{
                put("firstStatus", interviewInfMapper.getEvaluate("first").stream().collect(Collectors.toMap(NotEvaluate::getWished, NotEvaluate::getNotEvaluateNums)));
                put("secondStatus", interviewInfMapper.getEvaluate("second").stream().collect(Collectors.toMap(NotEvaluate::getWished, NotEvaluate::getNotEvaluateNums)));
                put("thirdStatus", interviewInfMapper.getEvaluate("third").stream().collect(Collectors.toMap(NotEvaluate::getWished, NotEvaluate::getNotEvaluateNums)));
            }});
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.InterviewInfServiceImpl.getEvaluate").warning(e.toString());
            return ReturnUtil.returnObj("查询失败", -6, null);
        }
    }
}
