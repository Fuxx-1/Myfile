package ltd.newimg.techat.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-08 23:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InviteLink {
    /*
    邀请链接
     */
    private String key; // 邀请密钥
    private Integer type; // 类型
    private String forward; // 用户名
    private Integer forwardId; // 群组id
}
