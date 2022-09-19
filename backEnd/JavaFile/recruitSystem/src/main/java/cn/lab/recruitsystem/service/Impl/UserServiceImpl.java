package cn.lab.recruitsystem.service.Impl;

import cn.lab.recruitsystem.Model.dto.User;
import cn.lab.recruitsystem.Model.dto.VerifyCodeEmail;
import cn.lab.recruitsystem.Util.*;
import cn.lab.recruitsystem.mapper.UserMapper;
import cn.lab.recruitsystem.service.UserService;
import com.alibaba.fastjson.JSONObject;
import freemarker.template.Template;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-04 23:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    MailUtil mailUtil;

    @Resource
    RedisUtil redisUtil;

    @Resource
    FreeMarkerConfigurer freeMarkerConfigurer;

    @Resource
    UserMapper userMapper;

    private ConcurrentHashMap keyMap = new ConcurrentHashMap(5);

    /**
     * 发送验证邮件验证码
     * Code By Fuxx-1@Github
     *
     * @param Email  邮箱
     * @param Action 行为
     * @return 是否成功发送code, msg, data
     */
    @Override
    public JSONObject sendVerifyEmail(String Email, String Action) {
        try {
            Integer times = (Integer) redisUtil.getCacheObject(Email + ":times");
            //获取发送次数
            if (times != null && times > 10) {
                return ReturnUtil.returnObj("发送次数过多", 1, null);
                //发送失败，原因如上
            } else {
                JSONObject sendResult = sendVerifyCode(Email, Action);
                if (sendResult.get("code").equals(0)) {
                    redisUtil.setCacheObject(Email + ":times", times == null ? 1 : times + 1, 12, TimeUnit.HOURS);
                    //发送成功次数加一
                }
                return sendResult;
            }
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.sendVerifyEmail.sendVerifyEmail").warning(e.toString());
            return ReturnUtil.returnObj("发送失败", -1, null);
        }
    }

    /**
     * 发送邮件的具体方法
     * Code By Fuxx-1@Github
     *
     * @param Email  邮箱
     * @param Action 行为
     * @return 是否发送成功
     */
    public JSONObject sendVerifyCode(String Email, String Action) {
        String Code = mailUtil.generateCode();
        try {
            String subject = "Union Lab纳新网站验证码";
            // 邮件标题
            redisUtil.setCacheObject(Email, Code, 10, TimeUnit.MINUTES);
            // 缓存验证码
            VerifyCodeEmail verifyCodeEmail = new VerifyCodeEmail(Action, Code, "Union Lab");
            // 拿取Email模板
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("verifyCodeEmail.html");
            String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, new HashMap<String, Object>() {{
                put("verifyCodeEmail", verifyCodeEmail);
            }});
            // 放入Code并转为Text
            mailUtil.sendHtmlMail(Email, subject, templateHtml);
            // 发送
            return ReturnUtil.returnObj("发送成功", 0, null);
            // 返回
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.sendVerifyEmail.sendVerifyCode").warning(e.toString());
            return ReturnUtil.returnObj("发送失败", -1, null);
        }
    }

    /**
     * 验证验证码
     * Code By Fuxx-1@Github
     *
     * @param Email 邮箱
     * @param Code
     * @return 是否正确code, msg, data
     */
    @Override
    public JSONObject verifyCode(String Email, String Code) {
        try {
            if (redisUtil.getCacheObject(Email).equals(Code)) {
                redisUtil.setCacheObject(Email, null);
                // 清空验证码
                return ReturnUtil.returnObj("验证码正确", 0, null);
                // 返回成功
            } else {
                return ReturnUtil.returnObj("验证码错误", 2, null);
                // 返回失败
            }
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.verifyCode").warning(e.toString());
            return ReturnUtil.returnObj("验证码验证失败", -2, null);
        }
    }

    /**
     * 注册新用户
     * Code By Fuxx-1@Github
     *
     * @param Email      邮箱
     * @param userid     学号
     * @param VerifyCode 验证码
     * @param password   密码
     * @return 是否注册成功
     */
    @Override
    public JSONObject signup(String Email, String userid, String VerifyCode, String password) {
        try {
            // 验证邮箱验证码
            JSONObject verifyResult = verifyCode(Email, VerifyCode);
            if (verifyResult.get("code").equals(0)) {
                // 邮箱验证码验证正确
                userMapper.addUser(userid);
                userMapper.updateMainInf(userid, password, Email);
                return ReturnUtil.returnObj("注册成功", 0, null);
            } else {
                // 邮箱验证码验证正错误，返回错误信息
                return verifyResult;
            }
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.signup").warning(e.toString());
            return ReturnUtil.returnObj("注册失败", -3, null);
        }
    }

    /**
     * 已注册使用密码登录，未注册可使用教务系统用户密码自动注册登录
     * Code By Fuxx-1@Github
     *
     * @param userid   用户id
     * @param password 密码
     * @return Token和登录状态
     */
    @Override
    public JSONObject login(String userid, String password) {
        try {
            String truePwd = userMapper.queryPwd(userid);
            if (truePwd == null || truePwd.length() == 0) {
                // 教务系统用户密码自动注册登录
                XUPTVerify test = new XUPTVerify();
                Map<String, String> testInfo = test.getStuInfo(userid, password);
                // 获取教务系统信息
                if (testInfo.isEmpty()) {
                    return ReturnUtil.returnObj("用户不存在或教务系统密码错误", 3, null);
                    // 信息为空，出现错误
                } else {
                    // 成功获取信息，开始注册
                    userMapper.addUser(userid);
                    userMapper.updateMainInf(userid, password, null);
                    userMapper.updateInf(userid, testInfo.get("name"), testInfo.get("gender").equals("M"), testInfo.get("group"), null, null);
                    String Token = JWTUtil.createToken(new HashMap<String, Object>() {{
                        put("userid", userid);
                        put("Auth", userMapper.getAuth(userid));
                    }});
                    User userInf = userMapper.getUserInf(userid);
                    return ReturnUtil.returnObj("创建成功", 0, new HashMap<String, Object>() {{
                        put("userInfo", userInf);
                        put("isComplete", userInf.isComplete());
                        put("Token", Token);
                    }});
                }
            } else {
                // 密码登录
                if (truePwd.equals(password)) {
                    // 密码正确
                    User userInf = userMapper.getUserInf(userid);
                    Boolean isComplete = userInf.isComplete();
                    userMapper.updateTime(userid);
                    // 信息是否补充完整
                    String Token = JWTUtil.createToken(new HashMap<String, Object>() {{
                        put("userid", userid);
                        put("Auth", userMapper.getAuth(userid));
                    }});
                    return ReturnUtil.returnObj("登录成功", 0, new HashMap<String, Object>() {{
                        put("userInfo", userInf);
                        put("isComplete", isComplete);
                        put("Token", Token);
                    }});
                } else {
                    // 密码错误
                    return ReturnUtil.returnObj("用户名或密码错误", 4, null);
                }
            }
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.login").warning(e.toString());
            return ReturnUtil.returnObj("登录失败", -4, null);
        }
    }

    /**
     * 更新信息
     * Code By Fuxx-1@Github
     *
     * @param user 用户id，及要更新的信息
     * @return 执行结果
     */
    @Override
    public JSONObject updataInf(User user) {
        try {
            user.completeInf(userMapper.getUserInf(user.getUserid()));
            userMapper.updateInf(user.getUserid(), user.getName(), user.getGender(), user.getMajor(), user.getPhone(), user.getWish());
            userMapper.updateTime(user.getUserid());
            return ReturnUtil.returnObj("更新成功", 0, userMapper.getUserInf(user.getUserid()));
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.updataInf").warning(e.toString());
            return ReturnUtil.returnObj("更新失败", -4, null);
        }
    }

    /**
     * 更新密码
     * Code By Fuxx-1@Github
     *
     * @param userid       用户id
     * @param password     密码，第一顺位
     * @param verifyCode   验证码，第二顺位
     * @param new_password 新密码
     * @return 执行结果
     */
    @Override
    public JSONObject resetPassword(String userid, String password, String verifyCode, String new_password) {
        try {
            User userInf = userMapper.getUserInf(userid);
            // 查询信息
            if (new_password == null || new_password.length() == 0) {
                new_password = userMapper.queryPwd(userid);
            }
            // 补充信息
            if (userMapper.queryPwd(userid).equals(password)) {
                // 第一顺位，密码验证成功
                userMapper.updateMainInf(userid, new_password, userInf.getEmail());
                userMapper.updateTime(userid);
                return ReturnUtil.returnObj("更新成功", 0, userMapper.getUserInf(userid));
            } else {
                JSONObject verifyResult = verifyCode(userInf.getEmail(), verifyCode);
                if (verifyResult.get("code").equals(0) && verifyCode != null && verifyCode.length() != 0) {
                    // 第二顺位，邮箱验证成功
                    userMapper.updateMainInf(userid, new_password, userInf.getEmail());
                    userMapper.updateTime(userid);
                    return ReturnUtil.returnObj("更新成功", 0, userMapper.getUserInf(userid));
                } else if (verifyCode != null && verifyCode.length() != 0) {
                    // 验证失败
                    return verifyResult;
                } else {
                    return ReturnUtil.returnObj("用户名或密码错误", 4, null);
                }
            }
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.resetPassword").warning(e.toString());
            return ReturnUtil.returnObj("更新失败", -4, null);
        }
    }

    /**
     * 更新新邮箱
     * Code By Fuxx-1@Github
     *
     * @param userid     用户id
     * @param password   密码
     * @param verifyCode 新邮箱验证码
     * @param newEmail   新邮箱
     * @return 执行结果
     */
    @Override
    public JSONObject resetEmail(String userid, String password, String verifyCode, String newEmail) {
        try {
            User userInf = userMapper.getUserInf(userid);
            // 查询信息
            if (newEmail == null || newEmail.length() == 0) {
                newEmail = userInf.getEmail();
            }
            // 补充信息
            JSONObject verifyResult = verifyCode(newEmail, verifyCode);
            if (userMapper.queryPwd(userid).equals(password) && verifyResult.get("code").equals(0) && verifyCode != null && verifyCode.length() != 0) {
                // 验证成功
                userMapper.updateMainInf(userid, userMapper.queryPwd(userid), newEmail);
                userMapper.updateTime(userid);
                return ReturnUtil.returnObj("更新成功", 0, userMapper.getUserInf(userid));
            } else {
                return ReturnUtil.returnObj("用户名或密码错误", 4, null);
            }
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.resetEmail").warning(e.toString());
            return ReturnUtil.returnObj("更新失败", -4, null);
        }
    }

    /**
     * 签到
     * Code By Fuxx-1@Github
     *
     * @param userid  用户id
     * @param is_sign 是否签到
     * @return 执行结果
     */
    @Override
    public JSONObject sign(String userid, Boolean is_sign) {
        try {
            userMapper.sign(userid, is_sign);
            userMapper.updateTime(userid);
            return ReturnUtil.returnObj("签到状态更改成功", 0, userMapper.getUserInf(userid));
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.sign").warning(e.toString());
            return ReturnUtil.returnObj("签到状态更改失败", -5, null);
        }
    }

    /**
     * 授权
     * Code By Fuxx-1@Github
     *
     * @param userid 被授权的用户id
     * @return 结果
     */
    @Override
    public JSONObject changeAuth(String userid) {
        try {
            userMapper.updateAuth(userid, 2);
            userMapper.updateTime(userid);
            return ReturnUtil.returnObj("更新成功", 0, null);
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.changeAuth").warning(e.toString());
            return ReturnUtil.returnObj("更新失败", -4, null);
        }
    }

    /**
     * 获取用户信息
     *
     * @param userid 用户id
     * @return 用户信息
     */
    @Override
    public JSONObject getInf(String userid) {
        try {
            return ReturnUtil.returnObj("查询成功", 0, userMapper.getUserInf(userid));
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.getInf").warning(e.toString());
            return ReturnUtil.returnObj("查询失败", -5, null);
        }
    }


    /**
     * 使用微信code进行登录
     *
     * @param code 前端获取到的code
     * @return Token和登录状态
     */
    @Override
    public JSONObject loginByWechatId(String code) {
        try {
            String openid = WeChatUtil.getOpenid(code);
            if (openid == null || openid.length() == 0) {
                return ReturnUtil.returnObj("微信服务出现问题", -1, null);
            }
            String userid = userMapper.getUseridByOpenid(openid);
            String Token = JWTUtil.createToken(new HashMap<String, Object>() {{
                put("userid", userid);
                put("Auth", userMapper.getAuth(userid));
            }});
            User userInf = userMapper.getUserInf(userid);
            return ReturnUtil.returnObj("创建成功", 0, new HashMap<String, Object>() {{
                put("userInfo", userInf);
                put("isComplete", userInf.isComplete());
                put("Token", Token);
            }});
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.connectWechatId").warning(e.toString());
            return ReturnUtil.returnObj("登录失败", -1, null);
        }
    }

    /**
     * 使用微信code进行登录
     *
     * @param userid 用户id
     * @param code   前端获取到的code
     * @return 是否成功
     */
    @Override
    public JSONObject connectWechatId(String userid, String code) {
        String openid = WeChatUtil.getOpenid(code);
        if (openid == null || openid.length() == 0) {
            return ReturnUtil.returnObj("微信服务出现问题", -1, null);
        }
        try {
            if (userMapper.getUseridByOpenid(openid) != null) {
                return ReturnUtil.returnObj("该微信已被绑定", -1, null);
            }
            userMapper.updateOpenid(userid, openid);
            return ReturnUtil.returnObj("更新成功", 0, null);
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.connectWechatId").warning(e.toString());
            return ReturnUtil.returnObj("登录失败", -1, null);
        }
    }

}
