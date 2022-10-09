package ltd.newimg.techat.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-09 0:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMessage {
    /*
    用户信息
     */
    private Integer userMessageId; // 用户信息id
    private String message; // 信息
    private String sender; // 发送者
    private String receiver; // 接收者
    private Date sendTime; // 发送时间
    private Date updateTime; // 更新时间
    private Integer sharedMessageId; // 被分享信息id
    private Integer sharedType; // 被分享信息类型
}
