package ltd.newimg.booksystem.service;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.booksystem.model.vo.AccreditVO;
import ltd.newimg.booksystem.model.vo.ChangePasswordVO;
import ltd.newimg.booksystem.model.vo.UserVO;

public interface UserService {
    /**
     * 注册
     * @param user 要注册的用户信息
     * @return 注册结果
     */
    JSONObject signup(UserVO user);

    /**
     * 登录
     * @param user 要登陆的用户信息
     * @return 登录结果
     */
    JSONObject login(UserVO user);

    /**
     * 更改密码
     * @param changePassword 要更改的密码信息
     * @return 更改结果
     */
    JSONObject changePassword(ChangePasswordVO changePassword);

    /**
     * 用户授权
     * @param username 要授权的用户名
     * @return 授权结果
     */
    JSONObject accredit(String username);

    JSONObject accredit(AccreditVO username);
}
