package ltd.newimg.booksystem.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQueryByNameVO {
    private String name;
    private Integer offset;
    private Integer size;
}
