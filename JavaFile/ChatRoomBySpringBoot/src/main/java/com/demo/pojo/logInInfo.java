package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fuxx-1
 * @date 2021年09月21日 22:34
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class logInInfo {
    private int id;
    private String password;
}