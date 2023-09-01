package ltd.newimg.booksystem.model.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ltd.newimg.booksystem.model.vo.BookEntiretyVO;
import ltd.newimg.booksystem.model.vo.UserVO;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private Boolean isAdmin;
    private String moreInfo;
    private Timestamp createTime;
    private Timestamp updateTime;

    public void updateWith(UserVO user) {
        if (user.getName() != null) this.name = user.getName();
        if (user.getMoreInfo() != null) this.moreInfo = user.getMoreInfo();
    }

    public String serializable() {
        return JSONObject.toJSONString(this);
    }
}
