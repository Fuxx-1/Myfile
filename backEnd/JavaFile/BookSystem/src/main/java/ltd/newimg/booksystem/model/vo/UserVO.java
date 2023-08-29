package ltd.newimg.booksystem.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private Integer id;
    private String name;
    private String password;
    private Boolean isAdmin;
    private String moreInfo;
    private Timestamp createTime;
    private Timestamp updateTime;
}
