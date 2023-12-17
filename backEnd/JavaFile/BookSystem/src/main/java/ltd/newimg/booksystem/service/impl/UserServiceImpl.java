package ltd.newimg.booksystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.booksystem.Util.NanoIdUtil;
import ltd.newimg.booksystem.Util.RedisUtil;
import ltd.newimg.booksystem.Util.ReturnUtil;
import ltd.newimg.booksystem.Util.en.ReturnCodeEnum;
import ltd.newimg.booksystem.config.UserHolder;
import ltd.newimg.booksystem.mapper.UserMapper;
import ltd.newimg.booksystem.model.dto.UserDTO;
import ltd.newimg.booksystem.model.vo.AccreditVO;
import ltd.newimg.booksystem.model.vo.ChangePasswordVO;
import ltd.newimg.booksystem.model.vo.UserVO;
import ltd.newimg.booksystem.service.UserService;
import org.springframework.stereotype.Component;
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
        // 检测重复并初始化权限信息
        if (userMapper.queryByName(user.getName()) != null) {
            return ReturnUtil.returnObj(ReturnCodeEnum.NAME_REPEAT, null);
        }
        user.setIsAdmin(false);
        // 添加用户
        Boolean addResult = userMapper.addUser(user);
        UserDTO userDTO = userMapper.queryById(user.getId());
        // 授权
        String id = NanoIdUtil.randomNanoId();
        redisUtil.setCacheObject(id, userDTO.serializable(), 1, TimeUnit.HOURS);
        // 判断结果
        if (addResult) {
            if (JSONObject.parseObject((String) redisUtil.getCacheObject(id), UserDTO.class).equals(userDTO)) {
                // 生成成功
                return ReturnUtil.returnObj(ReturnCodeEnum.SUCCESS, new HashMap<String, Object>() {{
                    put("id", id);
                }});
            } else {
                // 生成失败
                return ReturnUtil.returnObj(ReturnCodeEnum.SYSTEM_FAILED, null);
            }
        } else {
            // user 添加失败
            return ReturnUtil.returnObj(ReturnCodeEnum.DATA_ERROR, null);
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
            redisUtil.setCacheObject(id, userData.serializable(), 1, TimeUnit.HOURS);
            if (JSONObject.parseObject((String) redisUtil.getCacheObject(id), UserDTO.class).equals(userData)) {
                // 生成成功
                return ReturnUtil.returnObj(ReturnCodeEnum.SUCCESS, new HashMap<String, Object>() {{
                    put("id", id);
                }});
            } else {
                // 生成失败
                return ReturnUtil.returnObj(ReturnCodeEnum.SYSTEM_FAILED, null);
            }
        } else {
            // 密码错误
            return ReturnUtil.returnObj(ReturnCodeEnum.WRONG_PASSWORD, null);
        }
    }

    /**
     * 更新用户信息
     *
     * @param user 要更新的用户信息
     * @return 更新结果
     */
    @Override
    public JSONObject updateUser(UserVO user) {
        UserDTO actuallyUser = UserHolder.getUser();
        if (actuallyUser == null) {
            return ReturnUtil.returnObj(ReturnCodeEnum.ACCESS_DENIED, null);
        }
        if (userMapper.queryByName(user.getName()) != null) {
            return ReturnUtil.returnObj(ReturnCodeEnum.NAME_REPEAT, null);
        }
        UserDTO userDTO = userMapper.queryById(actuallyUser.getId());
        userDTO.updateWith(user);
        Boolean update = userMapper.update(userDTO);
        if (update) {
            // 更新成功
            return ReturnUtil.returnObj(ReturnCodeEnum.SUCCESS, null);
        } else {
            // 更新失败
            return ReturnUtil.returnObj(ReturnCodeEnum.DATA_ERROR, null);
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
        UserDTO userData = userMapper.queryById(UserHolder.getUser().getId());
        // 密码验证
        if (userData.getPassword().equals(changePassword.getPassword())) {
            // 密码正确
            userData.setPassword(changePassword.getNewPassword());
            Boolean update = userMapper.update(userData);
            if (update) {
                // 更新成功
                return ReturnUtil.returnObj(ReturnCodeEnum.SUCCESS, null);
            } else {
                // 更新失败
                return ReturnUtil.returnObj(ReturnCodeEnum.DATA_ERROR, null);
            }
        } else {
            // 密码错误
            return ReturnUtil.returnObj(ReturnCodeEnum.WRONG_PASSWORD, null);
        }
    }

    /**
     * 用户授权
     *
     * @param accredit 要授权的用户名
     * @return 授权结果
     */
    @Override
    public JSONObject accredit(AccreditVO accredit) {
        ThreadLocal<UserVO> threadLocal = new ThreadLocal<>();
        UserVO user = threadLocal.get();
        if (user.getIsAdmin()) {
            // 有权限增加管理员
            UserDTO userDTO = userMapper.queryByName(accredit.getAccreditName());
            userDTO.setIsAdmin(true);
            Boolean update = userMapper.update(userDTO);
            if (update) {
                // 权限增加成功
                return ReturnUtil.returnObj(ReturnCodeEnum.SUCCESS, null);
            } else {
                // 权限增加失败
                return ReturnUtil.returnObj(ReturnCodeEnum.ACCESS_DENIED, null);
            }
        } else {
            // 无权限增加管理员
            return ReturnUtil.returnObj(ReturnCodeEnum.WRONG_PASSWORD, null);
        }
    }
}
