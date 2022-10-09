package ltd.newimg.techat.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-08 23:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {
    /*
    语言配置
     */
    private String languageName; // 语言名
    private String content; // 语言配置
}
