package ltd.newimg.booksystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;
    private String password;
    private Boolean isAdmin;
    private String moreInfo;
    private Timestamp create_time;
    private Timestamp update_time;
}
