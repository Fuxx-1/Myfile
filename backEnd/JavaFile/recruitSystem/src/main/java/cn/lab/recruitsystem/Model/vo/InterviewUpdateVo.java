package cn.lab.recruitsystem.Model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-27 14:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewUpdateVo implements Serializable {
    private String userid;
    private Integer times;
    private String interview;
    private Integer attitude;
    private Integer ability;
    private String remarks;
    private Boolean ispass;
    private String interviewer;
    private Boolean final_ispass;
}
