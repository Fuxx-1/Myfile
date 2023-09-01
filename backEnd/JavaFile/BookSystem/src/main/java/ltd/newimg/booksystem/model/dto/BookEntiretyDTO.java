package ltd.newimg.booksystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ltd.newimg.booksystem.model.vo.BookEntiretyVO;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntiretyDTO {
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

    public void updateWith(BookEntiretyVO bookEntirety) {
        if (bookEntirety.getName() != null) name = bookEntirety.getName();
        if (bookEntirety.getPrice() != null) price = bookEntirety.getPrice();
        if (bookEntirety.getMargin() != null) margin = bookEntirety.getMargin();
        if (bookEntirety.getDetail() != null) detail = bookEntirety.getDetail();
        if (bookEntirety.getPicture() != null) picture = bookEntirety.getPicture();
        if (bookEntirety.getAuthor() != null) author = bookEntirety.getAuthor();
    }

}
