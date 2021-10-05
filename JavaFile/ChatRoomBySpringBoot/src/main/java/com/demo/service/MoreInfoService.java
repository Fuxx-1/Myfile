package com.demo.service;

import com.demo.pojo.MoreInfo;

import javax.servlet.http.HttpSession;

/**
 * @author Fuxx-1
 * @date 2021年09月27日 8:09
 */
public interface MoreInfoService {
    /**
     * 增加详细个人信息
     * @param moreinfo 需要增加的详细个人信息
     * @return 是否增加成功
     */
    String addMoreInfoService(MoreInfo moreinfo);

    /**
     * 查询详细个人信息
     * @param id 需要查询的id
     * @return 查询到的信息
     */
    String queryMoreInfoService(int id);

    /**
     * 删除详细个人信息
     * @param id 需要删除的id
     * @return 是否删除成功
     */
    String deleteMoreInfoService(int id);

    /**
     * 修改详细个人信息
     * @param moreinfo 需要修改的信息
     * @return 是否修改成功
     */
    String updateMoreInfoService(MoreInfo moreinfo, HttpSession session);

    /**
     * 查询昵称
     * @param id 需要查询的id
     * @return nickName
     */
    String queryNickname(int id);
}
