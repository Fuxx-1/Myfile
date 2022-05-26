package cn.lab.recruitsystem.Model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-22 16:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resetvo implements Serializable {
    private String userid;
    private String password;
    private String verifyCode;
    private String new_password;
    private String newEmail;
}
