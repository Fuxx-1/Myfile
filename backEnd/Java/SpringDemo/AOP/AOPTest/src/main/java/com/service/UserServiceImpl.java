package com.service;

import org.springframework.stereotype.Component;

/**
 * @author Fuxx-1
 * @date 2021年07月24日 9:45
 */
//真实对象，完成增删改查操作的人
@Component("userService")
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("增加了一个用户");
    }

    public void delete() {
        System.out.println("删除了一个用户");
    }

    public void update() {
        System.out.println("更新了一个用户");
    }

    public void query() {
        System.out.println("查询了一个用户");
    }
}


