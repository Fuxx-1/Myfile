package com.demo.service;

import com.demo.dao.UserDao;

public interface UserService {
    void getUser();
    void setUserDao(UserDao userDao);
}
