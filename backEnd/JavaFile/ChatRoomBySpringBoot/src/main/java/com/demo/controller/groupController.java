package com.demo.controller;

import com.demo.pojo.Group;
import com.demo.service.groupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Fuxx-1
 * @date 2021年09月28日 15:37
 */
@Controller
public class groupController {
    @Autowired
    groupService groupService;

    @PostMapping("/addgroup")
    @ResponseBody
    @CrossOrigin
    public String addGroup(Group group, HttpSession session) {
        return groupService.addGroup(group, session);
    }

    @PostMapping("/invitegroup")
    @ResponseBody
    @CrossOrigin
    public String inviteGroup(Group group) {
        return groupService.inviteGroup(group);
    }

    @PostMapping("/accept")
    @ResponseBody
    @CrossOrigin
    public String accept(HttpSession session, int groupId) {
        return groupService.accept(session, groupId);
    }

    @PostMapping("/delgroup")
    @ResponseBody
    @CrossOrigin
    public String delGroup(int groupId) {
        return groupService.delGroup(groupId);
    }

    @PostMapping("/updatenickname")
    @ResponseBody
    @CrossOrigin
    public String updateNickname(HttpSession session, int groupId, String groupNickname) {
        return groupService.updateNickname(session, groupId, groupNickname);
    }

    @PostMapping("/queryusergroups")
    @ResponseBody
    @CrossOrigin
    public String queryUserGroups(HttpSession session) {
        return groupService.queryUserGroups(session);
    }

    @PostMapping("/querygroupinfo")
    @ResponseBody
    @CrossOrigin
    public String queryGroupInfo(int groupId) {
        return groupService.queryGroupInfo(groupId);
    }

    @PostMapping("/changeadmin")
    @ResponseBody
    @CrossOrigin
    public String changeAdmin(int id, int groupId, boolean isAdmin) {
        return groupService.changeAdmin(id, groupId, isAdmin);
    }
}
