package cn.lab.recruitsystem.Model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-28 23:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldVo implements Serializable {
        private String field;
        private Boolean isDesc;
}
