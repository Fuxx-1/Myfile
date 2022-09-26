package com.demo.mapper;

import com.demo.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Fuxx-1
 * @date 2021年07月25日 23:32
 */
public interface UserMapper {
    @Select("select * from mybatis.user;")
    List<User> selectUser();

    @Insert("insert into mybatis.user (id, name, pwd) value (#{id}, #{name}, #{pwd});")
    int addUser(User user);

    @Delete("delete from mybatis.user where id = #{id}")
    int deleteUser(int id);
}
