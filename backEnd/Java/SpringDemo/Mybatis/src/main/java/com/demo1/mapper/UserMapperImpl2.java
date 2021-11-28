package com.demo1.mapper;

import com.demo1.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.List;

/**
 * @author Fuxx-1
 * @date 2021年07月24日 17:29
 */
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{
    @Override
    public List<User> selectUser() {
        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }
}
