package com.demo.service;

import com.demo.pojo.Friend;

import javax.servlet.http.HttpSession;

/**
 * @author Fuxx-1
 * @date 2021年09月27日 20:15
 */
public interface friendService {
    /**
     * 增加好友信息
     *
     * @param friend 传入信息
     * @return 是否增加成功
     */
    String addFriendInfo(int friendId, HttpSession session);

    /**
     * 删除好友信息
     *
     * @param friendId 注入信息
     * @return 是否删除成功
     */
    String deleteFriendInfo(int friendId, HttpSession session);

    /**
     * 查询好友信息
     *
     * @param id 用户id
     * @return 信息列表
     */
    String queryFriendInfo(HttpSession session);

    /**
     * 更新信息
     *
     * @param friendId 传入对象
     * @return 是否更改成功
     */
    String updateState(int friendId, HttpSession session);

}
