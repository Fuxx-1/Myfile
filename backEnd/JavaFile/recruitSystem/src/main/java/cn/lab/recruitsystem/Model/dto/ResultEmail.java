package cn.lab.recruitsystem.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-26 20:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEmail {
    private String name;
    // 姓名
    private String contact;
    // 联系方式
}
