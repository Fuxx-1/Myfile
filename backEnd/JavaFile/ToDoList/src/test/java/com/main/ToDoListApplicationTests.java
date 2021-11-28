package com.main;

import com.main.util.JWTUtil;
import com.main.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ToDoListApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

//    @Test
//    void contextLoads() {
//        Map<String, Object> temp = new HashMap<>();
//        temp.put("username", "123");
//        temp.put("email", "234");
//        String token = JWTUtil.createToken(temp);
//        System.out.println(token);
//        Map<String, Object> map = JWTUtil.parseToken(token);
//        System.out.println(map);
//    }

}
