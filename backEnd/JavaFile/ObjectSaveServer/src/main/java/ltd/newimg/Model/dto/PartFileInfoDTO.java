package ltd.newimg.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Eleun
 * @Description
 * @create 2022-07-26 15:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartFileInfoDTO implements Serializable {
    private String MD5;
    private String SHA1;
    private String suffix;
    private Integer chunkTotal;
    private Long fileSize;
}
