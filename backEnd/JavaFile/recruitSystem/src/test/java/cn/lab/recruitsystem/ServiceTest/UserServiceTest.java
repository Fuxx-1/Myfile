package cn.lab.recruitsystem.ServiceTest;

import cn.lab.recruitsystem.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-05 20:04
 */
@SpringBootTest
public class UserServiceTest {
    @Resource
    UserService userService;

    @Test
    public void sendVerifyEmail() {
        ApplicationContext applicationContext =
        System.out.println(userService.sendVerifyEmail("583742849@qq.com", "Test"));
    }

    @Test
    public void verifyCode() {
        System.out.println(userService.verifyCode("583742849@qq.com", "343292"));
    }
}
