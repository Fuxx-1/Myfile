package cn.lab.recruitsystem.Model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-27 14:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewQueryVo implements Serializable {
    private String similarName;
    private List<FieldVo> fields;
    private Integer page;
    private Integer limit;
}


