package com.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.demo.controller.WebSocketController;
import com.demo.mapper.GroupMapper;
import com.demo.pojo.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fuxx-1
 * @date 2021年09月27日 20:16
 */
@Service
public class groupServiceImpl implements groupService {
    @Autowired
    GroupMapper groupMapper;

    /**
     * 增加群组
     *
     * @param group 群组信息
     * @return 是否成功
     */
    @Override
    public String addGroup(Group group, HttpSession session) {
        JSONObject resp = new JSONObject();
        if (session.getAttribute("id") != null) {
            group.setId((Integer) session.getAttribute("id"));
            if (groupMapper.addGroup(group)) {
                resp.put("code", 0);
            } else {
                resp.put("code", -2);
                resp.put("msg", "添加失败");
            }
        } else {
            resp.put("code", -1);
            resp.put("msg", "未登录");
        }
        return resp.toJSONString();
    }

    /**
     * 邀请进群
     *
     * @param group 邀请信息
     * @return 是否邀请成功
     */
    @Override
    public String inviteGroup(Group group) {
        JSONObject resp = new JSONObject();
        JSONObject req = new JSONObject();
        if (groupMapper.queryGroupName(group.getGroupId()) != null) {
            group.setGroupName(groupMapper.queryGroupName(group.getGroupId()));
        } else {
            req.put("code", -3);
            req.put("msg", "group不存在");
            return resp.toJSONString();
        }
        if (groupMapper.inviteGroup(group)) {
            req.put("code", -2);
            req.put("groupRequest", group.getGroupId());
            try {
                WebSocketController.getClients().get(group.getId()).getBasicRemote().sendText(req.toJSONString());
            } catch (Exception ignored) {
            }
            resp.put("code", 0);
        } else {
            resp.put("code", -1);
            resp.put("msg", "添加失败");
        }
        return resp.toJSONString();
    }

    /**
     * 接受邀请
     *
     * @param session 用户id
     * @param groupid 群id
     * @return 是否成功
     */
    @Override
    public String accept(HttpSession session, int groupid) {
        JSONObject resp = new JSONObject();
        if (session.getAttribute("id") == null) {
            resp.put("code", -1);
            resp.put("msg", "未登录");
            return resp.toJSONString();
        }
        if (groupMapper.accept((Integer) session.getAttribute("id"), groupid)) {
            resp.put("code", 0);
        } else {
            resp.put("code", -1);
            resp.put("msg", "同意失败");
        }
        return resp.toJSONString();
    }

    /**
     * 解散群组
     *
     * @param groupid 群id
     * @return 是否成功
     */
    @Override
    public String delGroup(int groupid) {
        JSONObject resp = new JSONObject();
        if (groupMapper.delGroup(groupid)) {
            resp.put("code", 0);
        } else {
            resp.put("code", -1);
            resp.put("msg", "解散失败");
        }
        return resp.toJSONString();
    }

    /**
     * 更改权限
     *
     * @param id      用户id
     * @param groupId 群id
     * @return 是否成功
     */
    @Override
    public String changeAdmin(int id, int groupId, boolean isAdmin) {
        JSONObject resp = new JSONObject();
        if (groupMapper.changeAdmin(id, groupId, isAdmin)) {
            resp.put("code", 0);
        } else {
            resp.put("code", -1);
            resp.put("msg", "更改失败");
        }
        return resp.toJSONString();
    }

    /**
     * 更新群昵称
     *
     * @param id            用户id
     * @param groupid       群组id
     * @param groupnickname 用户在该群组内的昵称
     * @return 更改是否成功
     */
    @Override
    public String updateNickname(HttpSession session, int groupid, String groupnickname) {
        JSONObject resp = new JSONObject();
        int id = (int) session.getAttribute("id");
        if (groupMapper.updateNickname(id, groupid, groupnickname)) {
            resp.put("code", 0);
        } else {
            resp.put("code", -1);
            resp.put("msg", "更改失败");
        }
        return resp.toJSONString();
    }

    /**
     * 查询用户加入的群
     *
     * @param id 用户id
     * @return 群组信息
     */
    @Override
    public String queryUserGroups(HttpSession session) {
        JSONObject resp = new JSONObject();
        if (session.getAttribute("id") == null) {
            resp.put("code", -1);
            resp.put("msg", "未登录");
            return resp.toJSONString();
        }
        JSONObject Groups = new JSONObject();
        List<Group> Result = groupMapper.queryUserGroups((Integer) session.getAttribute("id"));
        for (Group result : Result) {
            Map<String, Object> group = new HashMap<>();
            group.put("groupName", result.getGroupName());
            if (result.isAdmin()) {
                group.put("identity", 0);
            } else if (result.isEstablish()) {
                group.put("identity", 1);
            } else {
                group.put("identity", -1);
            }
            if (result.isAdopted()) {
                group.put("isAdopted", result.isAdopted());
            }
            Groups.put(String.valueOf(result.getGroupId()), group);
        }
        resp.put("groups", Groups);
        resp.put("code", 0);
        return resp.toJSONString();
    }

    /**
     * 查询群信息
     *
     * @param groupid 群id
     * @return 群信息
     */
    @Override
    public String queryGroupInfo(int groupid) {
        JSONObject resp = new JSONObject();
        JSONObject groupInfo = new JSONObject();
        List<Group> Result = groupMapper.queryGroupInfo(groupid);
        for (Group result : Result) {
            if (result.isAdopted()) {
                Map<String, Object> group = new HashMap<>();
                resp.put("groupName", result.getGroupName());
                if (result.isAdmin()) {
                    group.put("identity", 0);
                } else if (result.isEstablish()) {
                    group.put("identity", 1);
                } else {
                    group.put("identity", -1);
                }
                if (result.isAdopted()) {
                    group.put("isAdopted", result.isAdopted());
                }
                group.put("groupNickName", result.getGroupNickname());
                groupInfo.put(String.valueOf(result.getId()), group);
            }
        }
        resp.put("groupInfo", groupInfo);
        resp.put("code", 0);
        return resp.toJSONString();
    }
}
