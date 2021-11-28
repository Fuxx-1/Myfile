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
public class Friend {
    private int myId;
    private int friendId;
    private boolean isAdopted;
}


// use `demo`;
// drop table if exists `friendinfo`;
// CREATE TABLE `friendinfo` (
//         `myid` INT NOT NULL COMMENT 'myid',
//         `friendid` INT NOT NULL COMMENT 'friendid',
//         `isadopted` TINYINT NOT NULL COMMENT '同意',
//         KEY `myid` (`myid`)
// ) ENGINE=INNODB DEFAULT CHARSET=utf8;
// drop table if exists `groupinfo`;
// CREATE TABLE `groupinfo` (
//         `id` INT NOT NULL COMMENT 'id',
//         `groupid` INT NOT NULL COMMENT 'groupid',
//         `groupname` varchar(20) NOT NULL COMMENT '群名',
//         `groupnickname` varchar(20) COMMENT '群昵称',
//         `isestablish` TINYINT NOT NULL COMMENT '群主',
//         `isadmin` TINYINT NOT NULL COMMENT '管理员',
//         `isadopted` TINYINT NOT NULL COMMENT '同意',
//         KEY `id` (`id`)
// ) ENGINE=INNODB DEFAULT CHARSET=utf8;
// drop table if exists `logininfo`;
// CREATE TABLE `logininfo` (
//         `id` INT NOT NULL COMMENT 'id',
//         `password` VARCHAR(20) NOT NULL COMMENT '密码',
//         KEY `id` (`id`)
// ) ENGINE=INNODB DEFAULT CHARSET=utf8;
// drop table if exists `moreInfo`;
// CREATE TABLE `moreInfo` (
//         `id` INT NOT NULL COMMENT 'id',
//         `avatar` VARCHAR(100) COMMENT '头像',
//         `nickname` VARCHAR(20) COMMENT '昵称',
//         `personalsign` VARCHAR(100) COMMENT '个性签名',
//         KEY `id` (`id`)
// ) ENGINE=INNODB DEFAULT CHARSET=utf8;