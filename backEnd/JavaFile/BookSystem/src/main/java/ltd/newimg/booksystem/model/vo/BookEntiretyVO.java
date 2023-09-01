package ltd.newimg.booksystem.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ltd.newimg.booksystem.model.dto.BookDetailDTO;
import ltd.newimg.booksystem.model.dto.BookEntiretyDTO;
import ltd.newimg.booksystem.model.dto.BookInfoDTO;

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
    private String author;
    private Integer createId;
    private Timestamp bookInfCreateTime;
    private Timestamp bookInfUpdateTime;
    private Timestamp bookDetailCreateTime;
    private Timestamp bookDetailUpdateTime;

    public BookDetailDTO toBookDetailDTO() {
        return new BookDetailDTO(id, detail, picture, author, null, null);
    }

    public BookInfoDTO toBookInfDTO() {
        return new BookInfoDTO(id, name, price, margin, createId, null, null);
    }
}
