package cn.newimg.service.Impl;

import cn.newimg.Util.ReturnUtil;
import cn.newimg.mapper.UserMapper;
import cn.newimg.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-04 23:06
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     * @return 是否成功
     */
    @Override
    public JSONObject addUser(String username, String password) {
        try {
            if (userMapper.queryPassword(username) == null) {
                userMapper.addUser(username, password);
                return ReturnUtil.returnObj("用户注册成功", 0, null);
            } else {
                // 用户已存在
                return ReturnUtil.returnObj("用户已存在", 1, null);
            }
        } catch (Exception e) {
            Logger.getLogger("c.n.s.I.UserServiceImpl.addUser").warning(e.toString());
            return ReturnUtil.returnObj("失败", -1, null);
        }
    }

    /**
     * 删除用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 是否成功
     */
    @Override
    public JSONObject delUser(String username, String password) {
        try {
            String tPassword = userMapper.queryPassword(username);
            if (tPassword.equals(password)) {
                userMapper.delUser(username);
                // 删除
                return  ReturnUtil.returnObj("删除成功", 0, null);
            } else {
                // 密码错误
                return  ReturnUtil.returnObj("密码错误", 1, null);
            }
        } catch (Exception e) {
            Logger.getLogger("c.n.s.I.UserServiceImpl.delUser").warning(e.toString());
            return ReturnUtil.returnObj("失败", -1, null);
        }
    }

    /**
     * 更新密码
     *
     * @param username     用户名
     * @param old_password 旧密码
     * @param new_password 新密码
     * @return 是否成功
     */
    @Override
    public JSONObject updateUser(String username, String old_password, String new_password) {
        try {
            String tPassword = userMapper.queryPassword(username);
            if (tPassword.equals(old_password)) {
                userMapper.updatePassword(username, new_password);
                // 更改
                return  ReturnUtil.returnObj("更新成功", 0, null);
            } else {
                // 密码错误
                return  ReturnUtil.returnObj("密码错误", 1, null);
            }
        } catch (Exception e) {
            Logger.getLogger("c.n.s.I.UserServiceImpl.updateUser").warning(e.toString());
            return ReturnUtil.returnObj("失败", -1, null);
        }
    }

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登陆状态
     */
    @Override
    public JSONObject login(String username, String password) {
        try {
            String tPassword = userMapper.queryPassword(username);
            if (tPassword.equals(password)) {
                return  ReturnUtil.returnObj("登录成功", 0, null);
            } else {
                // 密码错误
                return  ReturnUtil.returnObj("密码错误", 1, null);
            }
        } catch (Exception e) {
            Logger.getLogger("c.n.s.I.UserServiceImpl.addUser").warning(e.toString());
            return ReturnUtil.returnObj("失败", -1, null);
        }
    }
}
