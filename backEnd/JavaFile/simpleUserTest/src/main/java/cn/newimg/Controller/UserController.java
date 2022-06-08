package cn.newimg.Controller;

import cn.newimg.Model.dto.User;
import cn.newimg.Model.vo.ChangePasswordVo;
import cn.newimg.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:04
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;


    /**
     * 注册
     * @param user user信息
     * @return 是否成功
     */
    @RequestMapping("/add")
    String addUser(@RequestBody User user){
        return userService.addUser(user.getUsername(), user.getPassword()).toJSONString();
    }

    /**
     * 删除用户
     * @param user user信息
     * @return 是否成功
     */
    @RequestMapping("/del")
    String delUser(@RequestBody User user){
        return userService.delUser(user.getUsername(), user.getPassword()).toJSONString();
    }

    /**
     * 更新密码
     * @param changePasswordVo user信息
     * @return 是否成功
     */
    @RequestMapping("/update")
    String updateUser(@RequestBody ChangePasswordVo changePasswordVo){
        return userService.updateUser(changePasswordVo.getUsername(),
                changePasswordVo.getOld_password(), changePasswordVo.getNew_password()
        ).toJSONString();
    }

    /**
     * 登录
     * @param user user信息
     * @return 登陆状态
     */
    @RequestMapping("/login")
    String login(@RequestBody User user){
        return userService.login(user.getUsername(), user.getPassword()).toJSONString();
    }

}
