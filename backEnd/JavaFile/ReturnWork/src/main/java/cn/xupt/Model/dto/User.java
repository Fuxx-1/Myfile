package cn.lab.recruitsystem.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //用户id-学号
    private String userid;
    //姓名
    private String name;
    //密码
    private String password;
    //邮箱
    private String email;
    //手机
    private String phone;
    //权限
    private Integer auth;
    //方向
    private Integer wish;
    //创建时间
    private Date create_time;
    //更新时间
    private Date update_time;
}
