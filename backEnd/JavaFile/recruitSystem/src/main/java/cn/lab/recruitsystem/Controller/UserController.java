package cn.lab.recruitsystem.Controller;

import cn.lab.recruitsystem.Model.dto.User;
import cn.lab.recruitsystem.Model.vo.*;
import cn.lab.recruitsystem.Util.JWTUtil;
import cn.lab.recruitsystem.Util.ReturnUtil;
import cn.lab.recruitsystem.service.InterviewInfService;
import cn.lab.recruitsystem.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:04
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @Resource
    InterviewInfService interviewInfService;

    /**
     * 发送验证邮件验证码
     *
     * @param emailInfvo 邮箱及行为
     * @return Json
     */
    @RequestMapping("/user/sendVerifyEmail")
    String sendVerifyEmail(@RequestBody EmailInfvo emailInfvo) {
        return userService.sendVerifyEmail(emailInfvo.getEmail(), emailInfvo.getAction()).toJSONString();
    }

    /**
     * 注册新用户
     *
     * @param signupvo 注册信息
     * @return Json
     */
    @RequestMapping("/user/signup")
    String signup(@RequestBody(required = false) Signupvo signupvo) {
        JSONObject object = new JSONObject();
        String password = signupvo.getPassword();
        if (password == null || password.length() == 0) {
            signupvo.setPassword(signupvo.getUserid().substring(2, 8));
        }
        object.put("signResult", userService.signup(signupvo.getEmail(), signupvo.getUserid(), signupvo.getVerifyCode(), signupvo.getPassword()));
        if (signupvo.getCode() != null && signupvo.getCode().length() > 0) {
            object.put("connectResult", userService.connectWechatId(signupvo.getUserid(), signupvo.getCode()));
        }
        return object.toJSONString();
    }

    /**
     * 已注册使用密码登录，未注册可使用教务系统用户密码自动注册登录
     *
     * @param loginvo 登录信息
     * @return Token和登录状态
     */
    @RequestMapping("/user/login")
    String login(@RequestBody Loginvo loginvo) {
        return userService.login(loginvo.getUserid(), loginvo.getPassword()).toJSONString();
    }

    /**
     * 更新信息
     *
     * @param user 用户id，及要更新的信息
     * @return 执行结果
     */
    @RequestMapping("/user/updateInf")
    String updataInf(HttpServletRequest request, @RequestBody User user) {
        user.setUserid((String) JWTUtil.parseToken(request.getHeader("access_token")).get("userid"));
        return userService.updataInf(user).toJSONString();
    }

    /**
     * 更新密码和新邮箱
     *
     * @param resetvo 更新信息
     * @return 执行结果
     */
    @RequestMapping("/user/resetPassword")
    String resetPassword(@RequestBody Resetvo resetvo) {
        return userService.resetPassword(resetvo.getUserid(), resetvo.getPassword(), resetvo.getVerifyCode(), resetvo.getNew_password()).toJSONString();
    }


    /**
     * 更新密码和新邮箱
     * @param resetvo 更新信息
     * @return 执行结果
     */
    @RequestMapping("/user/resetEmail")
    String resetEmail(@RequestBody Resetvo resetvo) {
        return userService.resetEmail(resetvo.getUserid(), resetvo.getPassword(), resetvo.getVerifyCode(), resetvo.getNewEmail()).toJSONString();
    }

    /**
     * 签到
     *
     * @return 结果
     */
    @RequestMapping("/user/sign")
    String sign(HttpServletRequest request) {
        return ReturnUtil.returnMsg("执行成功", 0, new HashMap<String, Object>(2) {{
            put("signResult", userService.sign((String) JWTUtil.parseToken(request.getHeader("access_token")).get("userid"), true));
            put("createResult", interviewInfService.addInterview((String) JWTUtil.parseToken(request.getHeader("access_token")).get("userid")));
        }});
    }

    /**
     * 取消签到
     *
     * @param userid 要取消签到的用户id
     * @return 结果
     */
    @RequestMapping("/admin/unsetsign")
    String unsetsign(String userid) {
        return userService.sign(userid, false).toJSONString();
    }


    /**
     * 获取信息
     * @return 结果
     */
    @RequestMapping("/user/getInf")
    String getInf(HttpServletRequest request) {
        return userService.getInf((String) JWTUtil.parseToken(request.getHeader("access_token")).get("userid")).toJSONString();
    }

    /**
     * 获取信息(他人)
     * @return 结果
     */
    @RequestMapping("/admin/getInf")
    String getUserInf(String userid) {
        return userService.getInf(userid).toJSONString();
    }

    /**
     * 授权
     *
     * @param userid 用户id
     * @return 授权结果
     */
    @RequestMapping("/super_admin/changeAuth")
    String changeAuth(String userid) {
        return userService.changeAuth(userid).toJSONString();
    }

    /**
     * 使用微信code进行登录
     * @param code 前端获取到的code
     * @return Token和登录状态
     */
    @RequestMapping("/user/loginByWechatId")
    String loginByWechatId(@RequestBody CodeVo code) {
        return userService.loginByWechatId(code.getCode()).toJSONString();
    }

    /**
     * 使用微信code进行登录
     * @param request 拿取用户id
     * @param code 前端获取到的code
     * @return 是否成功
     */
    @RequestMapping("/user/connectWechatId")
    String connectWechatId(HttpServletRequest request, @RequestBody CodeVo code) {
        String userid = (String) JWTUtil.parseToken(request.getHeader("access_token")).get("userid");
        return userService.connectWechatId(userid, code.getCode()).toJSONString();
    }
}
