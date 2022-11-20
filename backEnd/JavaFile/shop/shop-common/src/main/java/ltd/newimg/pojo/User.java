package ltd.newimg.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-20 23:12
 */
@Entity(name = "shop_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid; // 用户id
    private String username; // 用户名
    private String password; // 密码
    private String telephone; // 手机号

}
