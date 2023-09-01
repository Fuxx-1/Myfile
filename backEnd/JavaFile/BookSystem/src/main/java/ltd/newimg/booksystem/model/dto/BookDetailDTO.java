package ltd.newimg.booksystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailDTO {

    private Integer id;
    private String detail;
    private String picture;
    private String author;
    private Timestamp createTime;
    private Timestamp updateTime;
}
