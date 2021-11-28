package com.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.demo.mapper.GroupMapper;
import com.demo.pojo.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Fuxx-1
 * @date 2021年09月23日 21:36
 */
@Service
public class MessageSendServiceImpl {
    @Autowired
    private static GroupMapper groupMapper;

    @Autowired
    public void setGroupMapper(GroupMapper groupMapper) {
        MessageSendServiceImpl.groupMapper = groupMapper;
    }

    public static void sendMessage(ConcurrentHashMap<Integer, Session> clients, int id, String message) {
        JSONObject req = JSONObject.parseObject(message);
        if (req.get("groupId") != null) {
            JSONObject resp = new JSONObject();
            resp.put("code", 0);
            resp.put("msg", req.get("message"));
            resp.put("from", id);
            resp.put("group", req.get("groupId"));
            List<Group> List = groupMapper.queryGroupInfo((Integer) req.get("groupId"));
            for (Group member : List) {
                if (member.getId() != id) {
                    try {
                        clients.get(member.getId()).getBasicRemote().sendText(resp.toJSONString());
                    } catch (Exception ignored) {
                    }
                }
            }
        } else if (req.get("friendId") != null) {
            JSONObject resp = new JSONObject();
            resp.put("code", 0);
            resp.put("msg", req.get("message"));
            resp.put("from", id);
            try {
                clients.get(req.get("friendId")).getBasicRemote().sendText(resp.toJSONString());
            } catch (Exception ignored) {
            }
        }
    }
}
