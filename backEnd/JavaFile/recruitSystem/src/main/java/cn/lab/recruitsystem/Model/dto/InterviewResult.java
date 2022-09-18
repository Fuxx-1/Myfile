package cn.lab.recruitsystem.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-08-03 16:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewResult {
    private String userid;
    // 用户id

    private String first_isCommit;
    // 一面评价
    private Boolean first_ispass;
    // 一面是否通过
    private String first_interviewer;
    // 一面面试官

    private String second_isCommit;
    // 二面评价
    private Boolean second_ispass;
    // 二面是否通过
    private String second_interviewer;
    // 二面面试官

    private String third_isCommit;
    // 三面评价
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

    public InterviewResult hideInterviewer() {
        StringBuffer sb = null;
        if (first_interviewer != null && first_interviewer.length() > 0) {
            sb = new StringBuffer(first_interviewer);
            sb.setCharAt(1, '*');
            first_interviewer = sb.toString();
        }
        if (second_interviewer != null && second_interviewer.length() > 0) {

            sb = new StringBuffer(second_interviewer);
            sb.setCharAt(1, '*');
            second_interviewer = sb.toString();
        }
        if (third_interviewer != null && third_interviewer.length() > 0) {

            sb = new StringBuffer(third_interviewer);
            sb.setCharAt(1, '*');
            third_interviewer = sb.toString();
        }
        return this;
    }

    public Boolean isComplete(Integer round) {
        switch (round) {
            case 1:
                return first_interviewer != null && first_ispass != null && first_isCommit != null;
            case 2:
                return second_interviewer != null && second_ispass != null && second_isCommit != null;
            case 3:
                return third_interviewer != null && third_ispass != null && third_isCommit != null;
            default:
                return false;
        }
    }
}
