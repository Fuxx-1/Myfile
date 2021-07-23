package com.demo.dao;

import com.demo.pojo.User;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * @create: 2021-07-22 11:25
 **/
public interface UserMapper {
    List<User> getUserList();//查询全部用户
    User getUserById(int id);//根据id查询用户
    Integer addUser(User user);//新建用户
    Integer updateUser(User user);//修改用户

    @Delete("delete from mybatis.user where id = #{id}")
    Integer deleteUser(int id);//删除用户
}
