package com.demo1.mapper;

import com.demo1.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.List;

/**
 * @author Fuxx-1
 * @date 2021年07月24日 17:02
 */
public class UserMapperImpl implements UserMapper{
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> selectUser() {
        return sqlSession.getMapper(UserMapper.class).selectUser();
    }
}
