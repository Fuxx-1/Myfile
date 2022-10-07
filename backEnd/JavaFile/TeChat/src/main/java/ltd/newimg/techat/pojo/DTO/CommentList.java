package ltd.newimg.techat.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-07 22:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentList {
    /*
    相关评论列表
     */
    private String comment; // 评论内容
    private Integer groupId; // 被评论群组id
    private Integer commentId; // 评论id
    private String sender; // 发送者
    private Integer groupMessageId; // 被评论信息id
    private String createTime; // 创建时间
    private String updateTime; // 更新时间
}
