package ltd.newimg.techat.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-09 0:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupRelation {
    /*
    用户群组关联性信息
     */
    private String username; // 用户名
    private Integer groupId; // 群组id
    private Integer isBlock; // 是否被禁
    private Integer identity; // 身份
    private Integer readMessageId; // 该用户读到第多少条消息
}
