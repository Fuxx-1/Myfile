package com.demo.service;

import com.demo.pojo.Group;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface groupService {
    /**
     * 增加群组
     *
     * @param group 群组信息
     * @return 是否成功
     */
    String addGroup(Group group, HttpSession session);

    /**
     * 邀请进群
     *
     * @param group 邀请信息
     * @return 是否邀请成功
     */
    String inviteGroup(Group group);

    /**
     * 接受邀请
     *
     * @param id      用户id
     * @param groupid 群id
     * @return 是否成功
     */
    String accept(HttpSession session, int groupid);

    /**
     * 解散群组
     *
     * @param groupid 群id
     * @return 是否成功
     */
    String delGroup(int groupid);

    /**
     * 更新群昵称
     *
     * @param id            用户id
     * @param groupid       群组id
     * @param groupnickname 用户在该群组内的昵称
     * @return 更改是否成功
     */
    String updateNickname(HttpSession session, int groupid, String groupnickname);

    /**
     * 查询用户加入的群
     *
     * @param id 用户id
     * @return 群组信息
     */
    String queryUserGroups(HttpSession session);

    /**
     * 查询群信息
     *
     * @param groupid 群id
     * @return 群信息
     */
    String queryGroupInfo(int groupid);

    /**
     * 更改权限
     * @param id 用户id
     * @param groupId 群id
     * @return 是否成功
     */
    String changeAdmin(int id, int groupId, boolean isAdmin);
}
