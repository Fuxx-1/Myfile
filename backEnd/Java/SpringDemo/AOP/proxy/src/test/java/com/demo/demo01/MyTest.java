package com.demo.demo01;

import com.demo.demo02.service.UserServiceImpl;
import com.demo.demo02.service.UserServiceProxy;
import org.junit.Test;

public class MyTest {
    @Test
    public void Test() {
        //房东要租房
        Host host = new Host();
        //中介代理租房，存在附属操作
        Proxy proxy = new Proxy(host);
        //找中介租房
        proxy.rent();
    }

    @Test
    public void Test2() {
        //真实业务
        UserServiceImpl userService = new UserServiceImpl();
        //代理类
        UserServiceProxy proxy = new UserServiceProxy();
        //使用代理类实现日志功能！
        proxy.setUserService(userService);
        proxy.add();
    }
}