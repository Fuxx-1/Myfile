package cn.lab.recruitsystem.Controller;

import cn.lab.recruitsystem.Model.dto.User;
import cn.lab.recruitsystem.Model.vo.EmailInfvo;
import cn.lab.recruitsystem.Model.vo.Loginvo;
import cn.lab.recruitsystem.Model.vo.Resetvo;
import cn.lab.recruitsystem.Model.vo.Signupvo;
import cn.lab.recruitsystem.Util.JWTUtil;
import cn.lab.recruitsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    String signup(@RequestBody Signupvo signupvo) {
        return userService.signup(signupvo.getEmail(), signupvo.getUserid(), signupvo.getVerifyCode(), signupvo.getPassword()).toJSONString();
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
    @RequestMapping("/user/resetMainInf")
    String changePassword(@RequestBody Resetvo resetvo) {
        return userService.resetMainInf(resetvo.getUserid(), resetvo.getPassword(), resetvo.getVerifyCode(), resetvo.getNew_password(), resetvo.getNewEmail()).toJSONString();
    }

    /**
     * 签到
     *
     * @return 结果
     */
    @RequestMapping("/user/sign")
    String sign(HttpServletRequest request) {
        return userService.sign((String) JWTUtil.parseToken(request.getHeader("access_token")).get("userid"), true).toJSONString();
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
     * 授权
     *
     * @param userid 用户id
     * @return 授权结果
     */
    @RequestMapping("/super_admin/changeAuth")
    String changeAuth(String userid) {
        return userService.changeAuth(userid).toJSONString();
    }

}