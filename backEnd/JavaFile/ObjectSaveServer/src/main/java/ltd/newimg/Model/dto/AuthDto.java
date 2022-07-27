package ltd.newimg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-05-28 21:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDTO {
    private String regex;
    private int askedAuth;
}
