package ltd.newimg.booksystem.model.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ltd.newimg.booksystem.demos.web.User;
import ltd.newimg.booksystem.model.dto.UserDTO;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private Boolean isAdmin;
    private String moreInfo;
    private Timestamp createTime;
    private Timestamp updateTime;

    public String serializable() {
        return JSONObject.toJSONString(this);
    }

    public UserDTO toUserDTO() {
        return new UserDTO(id, name, password, isAdmin, moreInfo, createTime, updateTime);
    }
}
