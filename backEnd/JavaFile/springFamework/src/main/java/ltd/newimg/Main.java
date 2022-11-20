package ltd.newimg;

import ltd.newimg.service.UserService;
import ltd.spring.MyApplicationContext;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        MyApplicationContext myApplicationContext = new MyApplicationContext(AppConfig.class);
        UserService userService = (UserService) myApplicationContext.getBean("userService");
        userService.testOrderService();
        userService.testBeanName();
    }
}