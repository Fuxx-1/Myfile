//package cn.lab.recruitsystem.UtilTest;
//
//import cn.lab.recruitsystem.Model.dto.VerifyCodeEmail;
//import cn.lab.recruitsystem.Util.MailUtil;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
//import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
//
//import javax.annotation.Resource;
//import javax.mail.MessagingException;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Eleun
// * @Description
// * @create 2022-04-29 23:38
// */
//@SpringBootTest
//public class MailUtilTest {
//
//
//    @Resource
//    MailUtil mailUtil;
//    @Resource
//    private FreeMarkerConfigurer freeMarkerConfigurer;
//
//    /**
//     * 测试发送简单文本邮件
//     */
//    @Test
//    void sendSimpleMail() {
//        mailUtil.sendSimpleMail("583742849@qq.com", "TestForSimpleMail", "TestForSimpleMail");
//    }
//
//    /**
//     * 测试发送Html格式的邮件
//     */
//    @Test
//    void sendHtmlMail() throws MessagingException, TemplateException, IOException {
////        String receiveEmail = "2987505357@qq.com";
////        String receiveEmail = "583742849@qq.com";
//        String receiveEmail = "test-2znoutd3a@srv1.mail-tester.com";
//        String subject = "UnionLab验证码";
//        //添加动态数据，替换模板里面的占位符
//        VerifyCodeEmail verifyCodeEmail = new VerifyCodeEmail("注册", mailUtil.generateCode(), "Union Laboratory");
//        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("verifyCodeEmail.html");
//        //将模板文件及数据渲染完成之后，转换为html字符串
//        Map<String, Object> model = new HashMap<>();
//        model.put("verifyCodeEmail", verifyCodeEmail);
//        String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
//        mailUtil.sendHtmlMail(receiveEmail, subject, templateHtml);
//    }
//
//    /**
//     * 测试发送包含附件的邮件
//     */
//    void sendAttachmentsMail() throws MessagingException {
//
//    }
//
//    @Test
//    void Code() throws MessagingException {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(mailUtil.generateCode());
//        }
//    }
//
//}
