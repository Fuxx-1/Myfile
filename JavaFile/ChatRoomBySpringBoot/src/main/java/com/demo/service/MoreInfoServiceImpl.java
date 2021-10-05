package com.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.demo.mapper.MoreInfoMapper;
import com.demo.pojo.MoreInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author Fuxx-1
 * @date 2021年09月27日 8:09
 */
@Service
public class MoreInfoServiceImpl implements MoreInfoService {

    @Autowired
    MoreInfoMapper moreInfoMapper;

    /**
     * 增加详细个人信息
     *
     * @param moreinfo 需要增加的详细个人信息
     * @return 是否增加成功
     */
    @Override
    public String addMoreInfoService(MoreInfo moreinfo) {
        JSONObject resp = new JSONObject();
        if (moreInfoMapper.addMoreInfo(moreinfo)) {
            resp.put("code", 0);
        } else {
            resp.put("code", -1);
            resp.put("msg", "增加失败");
        }
        return resp.toJSONString();
    }

    /**
     * 查询昵称
     *
     * @param id 需要查询的id
     * @return nickName
     */
    @Override
    public String queryNickname(int id) {
        JSONObject resp = new JSONObject();
        String Nickname = moreInfoMapper.queryMoreInfo(id).getNickName();
        if (Nickname == null) {
            resp.put("code", -1);
            resp.put("msg", "用户不存在");
        } else {
            resp.put("code", 0);
            resp.put("nickName", Nickname);
        }
        return resp.toJSONString();
    }

    /**
     * 查询详细个人信息
     *
     * @param id 需要查询的id
     * @return 查询到的信息
     */
    @Override
    public String queryMoreInfoService(int id) {
        JSONObject resp = new JSONObject();
        MoreInfo queryResult = moreInfoMapper.queryMoreInfo(id);
        if (queryResult.getNickName() == null) {
            resp.put("code", -1);
            resp.put("msg", "用户不存在或查询结果为空");
        } else {
            resp.put("code", 0);
            resp.put("nickName", queryResult.getNickName());
            resp.put("avatar", queryResult.getAvatar());
            resp.put("personalSign", queryResult.getPersonalSign());
            resp.put("id", queryResult.getId());
        }
        return resp.toJSONString();
    }

    /**
     * 删除详细个人信息
     *
     * @param id 需要删除的id
     * @return 是否删除成功
     */
    @Override
    public String deleteMoreInfoService(int id) {
        JSONObject resp = new JSONObject();
        if (moreInfoMapper.deleteMoreInfo(id)) {
            resp.put("code", 0);
        } else {
            resp.put("code", -1);
            resp.put("msg", "删除失败");
        }
        return resp.toJSONString();
    }

    /**
     * 修改详细个人信息
     *
     * @param moreinfo 需要修改的信息
     * @return 是否修改成功
     */
    @Override
    public String updateMoreInfoService(MoreInfo moreinfo, HttpSession session) {
        JSONObject resp = new JSONObject();
        if (session.getAttribute("id") != null) {
            moreinfo.setId((Integer) session.getAttribute("id"));
            MoreInfo queryResult;
            queryResult = moreInfoMapper.queryMoreInfo(moreinfo.getId());
            moreinfo.setId((Integer) session.getAttribute("id"));
            if (queryResult == null) {
                return addMoreInfoService(moreinfo);
            }
            if (moreinfo.getNickName() == null && queryResult.getNickName() != null) {
                moreinfo.setNickName(queryResult.getNickName());
            }
            if (moreinfo.getAvatar() == null && queryResult.getAvatar() != null) {
                moreinfo.setAvatar(queryResult.getAvatar());
            }
            if (moreinfo.getPersonalSign() == null && queryResult.getPersonalSign() != null) {
                moreinfo.setPersonalSign(queryResult.getPersonalSign());
            }
            if (moreInfoMapper.updateMoreInfo(moreinfo)) {
                resp.put("code", 0);
            } else {
                resp.put("code", -2);
                resp.put("msg", "更改失败");
            }
        } else {
            resp.put("code", -1);
            resp.put("msg", "未登录");
        }

        return resp.toJSONString();
    }
}
