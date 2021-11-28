package com.demo.service;

import com.demo.dao.UserDao;

/**
 * @create: 2021-07-23 09:50
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    //利用 Setter 方法实现值的动态注入
    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
