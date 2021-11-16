package com.main.mapper;

import com.main.pojo.ToDoList;
import com.main.pojo.User;
import com.main.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class ListMapper {
    @Autowired
    private RedisUtil redisUtil;

    public boolean setList(ToDoList list) {
        String flag = list.getUsername() + ":" + list.getDate();
        redisUtil.setCacheObject(flag, list);
        return getList(list.getUsername(), list.getDate()).equals(list);
    }

    public ToDoList getList(String username, String date) {
        String flag = username + ":" + date;
        return (ToDoList) redisUtil.getCacheObject(flag);
    }

    public boolean delList(String username, String date) {
        String flag = username + ":" + date;
        redisUtil.deleteObject(flag);
        return getList(username, date) == null;
    }
}
