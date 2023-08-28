package ltd.newimg.booksystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailDTO {

    private Integer id;
    private String detail;
    private String picture;
    private Integer author;
    private Timestamp create_time;
    private Timestamp update_time;
}
