package cn.newimg.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String username;
    //用户id-学号
    private String password;
    // 密码
}
