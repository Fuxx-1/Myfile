package com.demo.dao;

import com.demo.pojo.User;
import com.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @create: 2021-07-22 11:41
 **/
public class UserMapperTest {
    @Test
    public void getUserList() {
        SqlSession sqlSession = null;
        try {
            //获得SqlSession对象
            sqlSession = MybatisUtils.getSession();

            //执行SQL

            //1.利用getMapper()实现
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();


            //2.直接执行已映射的SQL语句(已过时)
            //List<User> userList = sqlSession.selectList("com.demo.dao.UserMapper.getUserList");

            //输出
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭SqlSession
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int res = mapper.addUser(new User(4, "王五", "22222"));
            if (res > 0) {
                System.out.println("插入成功!");
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateUser(new User(4, "王五改", "12345"));
            sqlSession.commit();
        } catch (Exception e) {
            e.getCause().printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUser(4);
            sqlSession.commit();
        } catch (Exception e) {
            e.getCause().printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
