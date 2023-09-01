package ltd.newimg.booksystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInfoDTO {

    private Integer id;
    private String name;
    private String price;
    private Integer margin;
    private Integer createId;
    private Timestamp createTime;
    private Timestamp updateTime;
}
