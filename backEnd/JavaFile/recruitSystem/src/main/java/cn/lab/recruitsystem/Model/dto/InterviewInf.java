package cn.lab.recruitsystem.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewInf {
    private String userid;
    // 用户id

    private String first_interview;
    // 一面评价
    private Integer first_attitude;
    // 一面态度分
    private Integer first_ability;
    // 一面能力分
    private String first_remarks;
    // 一面备注
    private Boolean first_ispass;
    // 一面是否通过
    private String first_interviewer;
    // 一面面试官

    private String second_interview;
    // 二面评价
    private Integer second_attitude;
    // 二面态度分
    private Integer second_ability;
    // 二面能力分
    private String second_remarks;
    // 二面备注
    private Boolean second_ispass;
    // 二面是否通过
    private String second_interviewer;
    // 二面面试官

    private String third_interview;
    // 三面评价
    private Integer third_attitude;
    // 三面态度分
    private Integer third_ability;
    // 三面能力分
    private String third_remarks;
    // 三面备注
    private Boolean third_ispass;
    // 三面是否通过
    private String third_interviewer;
    // 三面面试官

    private Boolean final_ispass;
    // 是否通过
    private Boolean is_send;
    // 邮件是否发送
    private String create_time;
    // 创建时间
    private String update_time;
    // 更新时间
}
