package cn.newimg.Model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-06-06 18:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordVo implements Serializable {
    private String username;
    // 用户名
    private String old_password;
    // 旧密码
    private String new_password;
    // 新密码
}
