package cn.lab.recruitsystem.Model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-22 0:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Signupvo implements Serializable {
    private String Email;
    private String userid;
    private String VerifyCode;
    private String password;
}
