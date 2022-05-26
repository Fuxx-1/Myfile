package cn.lab.recruitsystem.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-04-29 23:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerifyCodeEmail {
    //用户行为
    private String action;
    //验证码
    private String code;
    //公司
    private String company;
}
