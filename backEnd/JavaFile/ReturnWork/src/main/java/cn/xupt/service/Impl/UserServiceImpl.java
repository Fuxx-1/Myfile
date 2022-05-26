package cn.lab.recruitsystem.service.Impl;

import cn.lab.recruitsystem.Model.dto.VerifyCodeEmail;
import cn.lab.recruitsystem.Util.MailUtil;
import cn.lab.recruitsystem.Util.RedisUtil;
import cn.lab.recruitsystem.Util.ReturnUtil;
import cn.lab.recruitsystem.service.UserService;
import com.alibaba.fastjson.JSONObject;
import freemarker.template.Template;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
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

    /**
     * 发送验证邮件验证码
     *
     * @param Email  邮箱
     * @param Action 行为
     * @return 是否成功发送code, msg, data
     */
    @Override
    public JSONObject sendVerifyEmail(String Email, String Action) {
        String Code = mailUtil.generateCode();
        try {
            String subject = "Union Lab纳新网站验证码";
            redisUtil.setCacheObject(Email, Code,   10, TimeUnit.MINUTES);
            VerifyCodeEmail verifyCodeEmail = new VerifyCodeEmail(Action, Code, "Union Lab");
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("verifyCodeEmail.html");
            //将模板文件及数据渲染完成之后，转换为html字符串
//            Map<String, Object> model = new HashMap<>();
//            model.put("verifyCodeEmail", verifyCodeEmail);
            String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, new HashMap<String, Object>() {{
                put("verifyCodeEmail", verifyCodeEmail);
            }});
            //发送
            mailUtil.sendHtmlMail(Email, subject, templateHtml);
            //返回
            return ReturnUtil.returnObj("发送成功", 0, null);
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.sendVerifyEmail").warning(e.toString());
            return ReturnUtil.returnObj("发送失败", -1, null);
        }
    }

    /**
     * 验证验证码
     * @param Email 邮箱
     * @param Code
     * @return 是否正确code, msg, data
     */
    @Override
    public JSONObject verifyCode(String Email, String Code) {
        try {
            if (redisUtil.getCacheObject(Email).equals(Code)) {
                //返回成功
                return ReturnUtil.returnObj("验证码正确", 0, null);
            } else {
                //返回失败
                return ReturnUtil.returnObj("验证码错误", 1, null);
            }
        } catch (Exception e) {
            Logger.getLogger("c.l.r.s.I.UserServiceImpl.verifyCode").warning(e.toString());
            return ReturnUtil.returnObj("验证码验证失败", -1, null);
        }
    }
}
