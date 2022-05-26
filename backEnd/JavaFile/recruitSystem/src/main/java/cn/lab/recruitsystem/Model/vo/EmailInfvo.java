package cn.lab.recruitsystem.Model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-22 0:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailInfvo implements Serializable {
    private String email;
    private String action;
}
