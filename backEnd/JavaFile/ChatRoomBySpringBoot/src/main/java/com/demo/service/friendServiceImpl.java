package com.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.demo.controller.WebSocketController;
import com.demo.mapper.FriendMapper;
import com.demo.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Fuxx-1
 * @date 2021年09月27日 20:16
 */
@Service
public class friendServiceImpl implements friendService {
    @Autowired
    FriendMapper friendMapper;

    /**
     * 增加好友信息
     *
     * @param friend 传入信息
     * @return 是否增加成功
     */
    @Override
    public String addFriendInfo(int friendId, HttpSession session) {
        JSONObject resp = new JSONObject();
        JSONObject req = new JSONObject();
        if (session.getAttribute("id") == null) {
            resp.put("code", -1);
            resp.put("msg", "未登录");
            return resp.toJSONString();
        } else {
            if (friendMapper.addFriendInfo((Integer) session.getAttribute("id"), friendId)) {
                req.put("code", -1);
                req.put("friendRequest", session.getAttribute("id"));
                try {
                    WebSocketController.getClients().get((Integer) session.getAttribute("id")).getBasicRemote().sendText(req.toJSONString());
                } catch (Exception ignored) {
                }
                resp.put("code", 0);
            } else {
                resp.put("code", -2);
                resp.put("msg", "添加失败");
            }
        }
        return resp.toJSONString();
    }

    /**
     * 删除好友信息
     *
     * @param friend 注入信息
     * @return 是否删除成功
     */
    @Override
    public String deleteFriendInfo(int friendId, HttpSession session) {
        JSONObject resp = new JSONObject();
        if (session.getAttribute("id") != null) {
            if (friendMapper.deleteFriendInfo(new Friend((Integer) session.getAttribute("id"), friendId, false))) {
                resp.put("code", 0);
            } else {
                resp.put("code", -2);
                resp.put("msg", "删除失败");
            }
        } else {
            resp.put("code", -1);
            resp.put("msg", "未登录");
        }
        return resp.toJSONString();
    }

    /**
     * 查询好友信息
     *
     * @return 信息列表
     */
    @Override
    public String queryFriendInfo(HttpSession session) {
        JSONObject resp = new JSONObject();
        if (session.getAttribute("id") != null) {
            JSONObject FriendRequest = new JSONObject();
            JSONObject FriendResponse = new JSONObject();
            List<Friend> Result = friendMapper.queryFriendInfo((Integer) session.getAttribute("id"));
            resp.put("code", 0);
            for (Friend friend : Result) {
                if (friend.getMyId() == (Integer) session.getAttribute("id")) {
                    FriendRequest.put(String.valueOf(friend.getFriendId()), friend.isAdopted());
                } else {
                    FriendResponse.put(String.valueOf(friend.getMyId()), friend.isAdopted());
                }
            }
            resp.put("friendRequest", FriendRequest);
            resp.put("friendResponse", FriendResponse);
        } else {
            resp.put("code", -1);
            resp.put("msg", "未登录");
        }
        return resp.toJSONString();
    }

    /**
     * 更新信息
     *
     * @param friendId 传入对象
     * @return 是否更改成功
     */
    @Override
    public String updateState(int friendId, HttpSession session) {
        JSONObject resp = new JSONObject();
        if (session.getAttribute("id") != null) {
            if (friendMapper.updateState(new Friend((Integer) session.getAttribute("id"), friendId, false))) {
                resp.put("code", 0);
            } else {
                resp.put("code", -2);
                resp.put("msg", "更新失败");
            }
        } else {
            resp.put("code", -1);
            resp.put("msg", "未登录");
        }
        return resp.toJSONString();
    }
}
