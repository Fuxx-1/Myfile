package ltd.newimg.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-06-18 23:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileSaveDTO {
    private String saveDir;
    private String fileName;
    private InputStream file;
}
