package cn.lab.recruitsystem.Controller;

import cn.lab.recruitsystem.Model.vo.InterviewQueryVo;
import cn.lab.recruitsystem.Model.vo.InterviewUpdateVo;
import cn.lab.recruitsystem.Model.vo.ResultMailVo;
import cn.lab.recruitsystem.Util.JWTUtil;
import cn.lab.recruitsystem.Util.ReturnUtil;
import cn.lab.recruitsystem.service.InterviewInfService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:05
 */
@Controller
@ResponseBody
@RequestMapping("/interview")
public class InterviewInfController {

    @Resource
    InterviewInfService interviewInfService;

    /**
     * 增加用户面试信息
     *
     * @param userid 用户id
     * @return 是否成功
     */
    @RequestMapping("/admin/init")
    String addInterview(String userid) {
        return interviewInfService.addInterview(userid).toJSONString();
    }

    /**
     * 删除用户面试信息（SuperAdmin）
     *
     * @param userid 用户id
     * @return 是否成功
     */
    @RequestMapping("/super_admin/del")
    String delInterview(String userid) {
        return interviewInfService.delInterview(userid).toJSONString();
    }


    /**
     * 更新面试信息（评价）
     *
     * @param interviewUpdateVo 要更新的信息
     * @return 是否修改成功
     */
    @RequestMapping("/admin/update")
    String updateInterview(HttpServletRequest request, @RequestBody InterviewUpdateVo interviewUpdateVo) {
        interviewUpdateVo.setInterviewer((String) JWTUtil.parseToken(request.getHeader("access_token")).get("userid"));
        return interviewInfService.updateInterview(interviewUpdateVo.getUserid(), interviewUpdateVo.getTimes(),
                interviewUpdateVo.getInterview(), interviewUpdateVo.getAttitude(), interviewUpdateVo.getAbility(),
                interviewUpdateVo.getRemarks(), interviewUpdateVo.getIspass(), interviewUpdateVo.getInterviewer(),
                interviewUpdateVo.getFinal_ispass()).toJSONString();
    }

    /**
     * 以当前状态发送邮件
     *
     * @param resultMailVo 邮件信息
     * @return 是否成功
     */
    @RequestMapping("/admin/send")
    String sendEmail(@RequestBody ResultMailVo resultMailVo) {
        return interviewInfService.sendEmail(resultMailVo.getUserid(), resultMailVo.getContact()).toJSONString();
    }

    /**
     * 获取面试信息
     *
     * @return 用户面试信息（部分）
     */
    @RequestMapping("/user/get")
    String getInterviewInf(HttpServletRequest request) {
        String token = request.getHeader("access_token");
        if (JWTUtil.verifyToken(token) == 0) {
            Map<String, Object> authMap = JWTUtil.parseToken(token);
            return interviewInfService.getInterviewInf((String) authMap.get("userid")).toJSONString();
        } else {
            return ReturnUtil.returnMsg("查询失败", -5, null);
        }
    }

    /**
     * 查询用户面试状态，用于管理员
     *
     * @param interviewQueryVo 查询信息
     * @return 返回查询结果
     */
    @RequestMapping("/admin/query")
    String queryInterviewInf(@RequestBody InterviewQueryVo interviewQueryVo) {
        return interviewInfService.queryInterviewInf(interviewQueryVo.getSimilarName(), interviewQueryVo.getFields(), interviewQueryVo.getWish(), interviewQueryVo.getPage(),
                interviewQueryVo.getLimit()).toJSONString();
    }

    /**
     * 获取评价的相关信息
     *
     * @return 评价的相关信息
     */
    @RequestMapping("/user/getEvaluate")
    String getEvaluate() {
        return interviewInfService.getEvaluate().toJSONString();
    }

}
