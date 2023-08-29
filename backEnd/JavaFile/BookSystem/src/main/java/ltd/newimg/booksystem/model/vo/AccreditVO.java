package ltd.newimg.booksystem.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccreditVO {

    private Integer id;
    private String name;
    private String accreditName;
}
