package cn.lab.recruitsystem.Model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-27 14:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultMailVo implements Serializable {
    private String userid;
    private String contact;
}
