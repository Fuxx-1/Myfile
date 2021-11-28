package com.demo.mapper;

import com.demo.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author Fuxx-1
 * @date 2021年07月25日 23:33
 */
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    @Override
    public List<User> selectUser() {
        UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);
        userMapper.addUser(new User(4, "王五", "123123"));
        System.out.println(userMapper.deleteUser(4));
        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
