package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fuxx-1
 * @date 2021年09月21日 22:39
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private int id;
    private int groupId;
    private String groupName;
    private String groupNickname;
    private boolean isEstablish;
    private boolean isAdmin;
    private boolean isAdopted;
}