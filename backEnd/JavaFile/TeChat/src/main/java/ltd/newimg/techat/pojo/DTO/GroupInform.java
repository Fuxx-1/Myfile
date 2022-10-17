package ltd.newimg.techat.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-08 23:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupInform {
    /*
    群组主信息
     */
    private Integer groupId; // 群组id
    private String groupName; // 群组名
    private Integer type; // 类型
    private String bio; // 简介
    private Integer historySetting; // 信息历史设置
    private String emojiRecord; // 表情回复
    private String memberPermission; // 成员权限
}