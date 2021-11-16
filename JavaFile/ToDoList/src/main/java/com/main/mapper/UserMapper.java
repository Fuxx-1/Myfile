package com.main.mapper;

import com.main.pojo.User;
import com.main.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

@Repository
public class UserMapper {
    @Autowired
    private RedisUtil redisUtil;

    public boolean setUser(User user) {
        redisUtil.setCacheObject(user.getUsername(), user);
        return getUser(user.getUsername()) != null;
    }

    public User getUser(String username) {
        return (User) redisUtil.getCacheObject(username);
    }

    public boolean delUser(String username) {
        redisUtil.deleteObject(username);
        return getUser(username) == null;
    }

}
