package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fuxx-1
 * @date 2021年09月21日 22:45
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoreInfo {
    private int id;
    private String avatar;
    private String nickName;
    private String personalSign;
}