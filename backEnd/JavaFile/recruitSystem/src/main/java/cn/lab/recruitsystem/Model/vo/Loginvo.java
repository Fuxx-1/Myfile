package cn.lab.recruitsystem.Model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-22 0:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loginvo implements Serializable {
    private String userid;
    private String password;
}
