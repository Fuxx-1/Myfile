package ltd.newimg.booksystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.booksystem.Util.NanoIdUtil;
import ltd.newimg.booksystem.Util.RedisUtil;
import ltd.newimg.booksystem.Util.ReturnUtil;
import ltd.newimg.booksystem.mapper.UserMapper;
import ltd.newimg.booksystem.model.dto.UserDTO;
import ltd.newimg.booksystem.model.vo.AccreditVO;
import ltd.newimg.booksystem.model.vo.ChangePasswordVO;
import ltd.newimg.booksystem.model.vo.UserVO;
import ltd.newimg.booksystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    RedisUtil redisUtil;

    /**
     * 注册
     *
     * @param user 要注册的用户信息
     * @return 注册结果
     */
    @Override
    public JSONObject signup(UserVO user) {
        // 检测重复
        if (userMapper.queryByName(user.getName()) != null) {
            return ReturnUtil.returnObj("name重复", -1, null);
        }
        // 添加用户
        Boolean addResult = userMapper.addUser(user);
        // 授权
        String id = NanoIdUtil.randomNanoId();
        redisUtil.setCacheObject(id, user, 1, TimeUnit.HOURS);
        // 判断结果
        if (addResult) {
            if (redisUtil.getCacheObject(id).equals(user)) {
                // 生成成功
                return ReturnUtil.returnObj("ok", 0, new HashMap<String, Object>() {{
                    put("id", id);
                }});
            } else {
                // 生成失败
                return ReturnUtil.returnObj("生成失败", -1, null);
            }
        } else {
            // user 添加失败
            return ReturnUtil.returnObj("添加失败", -1, null);
        }
    }

    /**
     * 登录
     *
     * @param user 要登陆的用户信息
     * @return 登录结果
     */
    @Override
    public JSONObject login(UserVO user) {
        // 获取数据库信息
        UserDTO userData = userMapper.queryByName(user.getName());
        if (userData.getPassword().equals(user.getPassword())) {
            // 授权
            String id = NanoIdUtil.randomNanoId();
            redisUtil.setCacheObject(id, user, 1, TimeUnit.HOURS);
            if (redisUtil.getCacheObject(id).equals(user)) {
                // 生成成功
                return ReturnUtil.returnObj("ok", 0, new HashMap<String, Object>() {{
                    put("id", id);
                }});
            } else {
                // 生成失败
                return ReturnUtil.returnObj("生成失败", -1, null);
            }
        } else {
            // 密码错误
            return ReturnUtil.returnObj("密码错误", -1, null);
        }
    }

    /**
     * 更改密码
     *
     * @param changePassword 要更改的密码信息
     * @return 更改结果
     */
    @Override
    public JSONObject changePassword(ChangePasswordVO changePassword) {
        // 获取数据库信息
        UserDTO userData = userMapper.queryById(changePassword.getId());
        // 密码验证
        if (userData.getPassword().equals(changePassword.getPassword())) {
            // 密码正确
            userData.setPassword(changePassword.getNewPassword());
            Boolean update = userMapper.update(userData);
            if (update) {
                // 更新成功
                return ReturnUtil.returnObj("更新成功", 0, null);
            } else {
                // 更新失败
                return ReturnUtil.returnObj("更新失败", -1, null);
            }
        } else {
            // 密码错误
            return ReturnUtil.returnObj("密码错误", -1, null);
        }
    }

    /**
     * 用户授权
     *
     * @param username 要授权的用户名
     * @return 授权结果
     */
    @Override
    public JSONObject accredit(AccreditVO username) {
        ThreadLocal<UserVO> threadLocal = new ThreadLocal<>();
        UserVO user = threadLocal.get();
        if (user.getIsAdmin()) {
            // 有权限增加管理员
        } else {
            // 无权限增加管理员
            return ReturnUtil.returnObj("密码错误", -1, null);
        }
        return null;
    }
}
