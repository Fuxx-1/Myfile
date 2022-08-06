package cn.lab.recruitsystem.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-08-03 21:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotEvaluate {
    private Integer notEvaluateNums; // 未评价人数
    private Integer wish; // 组别
    private Integer interviewNum; // 第几面

    public String getWished() {
        return this.wish.toString();
    }
}
