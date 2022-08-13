package ltd.newimg.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Eleun
 * @Description
 * @create 2022-07-26 16:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartFileDTO {
    private Integer chunkIndex;
    private Integer chunkTotal;
    private MultipartFile file;
    private String MD5;
    private String totalMD5;
    private String totalSHA1;
}
