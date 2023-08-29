package ltd.newimg.booksystem.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntiretyVO {
    private Integer id;
    private String name;
    private String price;
    private Integer margin;
    private String detail;
    private String picture;
    private Integer author;
    private Integer create_id;
    private Timestamp bookInfCreateTime;
    private Timestamp bookInfUpdateTime;
    private Timestamp bookDetailCreateTime;
    private Timestamp bookDetailUpdateTime;

}
