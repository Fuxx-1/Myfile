package ltd.newimg.techat.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-07 23:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupMessage {
    /*
    群组信息
     */
    private Integer groupMessageId; // 信息id
    private String message; // 信息
    private String sender; // 发送者用户名
    private Integer groupId; // 群组id
    private Integer sharedMessageId; // 被分享信息id
    private Integer sharedType; // 被分享信息类型
    private String createTime; // 创建时间
    private String updateTime; // 更新时间
}