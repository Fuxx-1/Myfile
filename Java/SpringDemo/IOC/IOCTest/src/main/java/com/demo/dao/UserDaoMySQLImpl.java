package com.demo.dao;

/**
 * @author Fuxx-1
 * @date 2021年07月23日 11:04
 */
public class UserDaoMySQLImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("MySQL获取用户数据");
    }
}
