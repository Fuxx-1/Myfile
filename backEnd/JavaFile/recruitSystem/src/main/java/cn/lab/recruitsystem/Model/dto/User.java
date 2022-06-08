package cn.lab.recruitsystem.Model.dto;

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
    private String userid;
    //用户id-学号
    private String password;
    // 密码
    private String name;
    // 姓名
    private Boolean gender;
    // 性别
    private String major;
    // 班级
    private String email;
    // 邮箱
    private String phone;
    // 手机
    private Integer auth;
    // 权限
    private Integer wish;
    // 方向
    private Boolean is_sign;
    // 是否签到
    private String create_time;
    // 创建时间
    private String update_time;
    // 更新时间

    /**
     * 查询个人信息是否完善
     * @return 个人信息是否完善
     */
    public Boolean isComplete() {
        return this.name != null && this.name.length() != 0 && this.gender != null && this.major != null && this.major.length() != 0 && this.email != null && this.email.length() != 0 && this.phone != null && this.phone.length() != 0;
    }

    /**
     * 用参数中的值完善本身
     * @param old_user 差数
     */
    public void completeInf(User old_user) {
        if (this.name == null || this.name.length() == 0) {
            this.name = old_user.getName();
        }
        if (this.gender == null) {
            this.gender = old_user.getGender();
        }
        if (this.major == null || this.major.length() == 0) {
            this.major = old_user.getMajor();
        }
        if (this.phone == null || this.phone.length() == 0) {
            this.phone = old_user.getPhone();
        }
        if (this.wish == null) {
            this.wish = old_user.getWish();
        }
        if (this.email == null || this.email.length() == 0) {
            this.email = old_user.getEmail();
        }
    }
}
