package ltd.newimg.booksystem.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordVO {

    private Integer id;
    private String password;
    private String newPassword;
}
