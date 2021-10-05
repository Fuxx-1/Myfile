package com.demo.mapper;

import com.demo.pojo.Group;
import org.apache.ibatis.annotations.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Mapper
public interface GroupMapper {
    /**
     * 增加群组
     *
     * @param group 群组信息
     * @return 是否成功
     */
    @Insert("insert into demo.groupinfo(id, groupid, groupname, groupnickname, isestablish, isadmin, isadopted) VALUES (#{id}, #{groupId}, #{groupName}, null, 1, 0, 1)")
    boolean addGroup(Group group);

    /**
     * 邀请进群
     *
     * @param group 邀请信息
     * @return 是否邀请成功
     */
    @Insert("insert into demo.groupinfo(id, groupid, groupname, groupnickname, isestablish, isadmin, isadopted) VALUES (#{id}, #{groupId}, #{groupName}, null, 0, 0, 0)")
    boolean inviteGroup(Group group);

    /**
     * 接受邀请
     *
     * @param id      用户id
     * @param groupid 群id
     * @return 是否成功
     */
    @Update("update demo.groupinfo set isadopted = 1 where id = #{id} and groupid = #{groupId}")
    boolean accept(int id, int groupId);

    /**
     * 设置管理员
     *
     * @param id      用户id
     * @param groupId 群id
     * @return 是否成功
     */
    @Update("update demo.groupinfo set isadmin = #{isadmin} where id = #{id} and groupid = #{groupId}")
    boolean changeAdmin(int id, int groupId, boolean isadmin);

    /**
     * 解散群组
     *
     * @param groupid 群id
     * @return 是否成功
     */
    @Delete("delete from demo.groupinfo where groupid = #{groupId}")
    boolean delGroup(int groupId);

    /**
     * 更新群昵称
     * @param id 用户id
     * @param groupid 群组id
     * @param groupnickname 用户在该群组内的昵称
     * @return 更改是否成功
     */
    @Update("update demo.groupinfo set groupnickname = #{groupNickname} where id = #{id} and groupid = #{groupId}")
    boolean updateNickname(int id, int groupId, String groupNickname);

    /**
     * 查询用户加入的群
     * @param id 用户id
     * @return 群组信息
     */
    @Select("select * from demo.groupinfo where id = #{id}")
    List<Group> queryUserGroups(int id);

    /**
     * 查询群信息
     * @param groupid 群id
     * @return 群信息
     */
    @Select("select * from demo.groupinfo where groupid = #{groupId}")
    List<Group> queryGroupInfo(int groupId);

    /**
     * 查询群组名
     * @param groupId 群组id
     * @return 群组名
     */
    @Select("select groupname from demo.groupinfo where groupid = #{groupId}")
    String queryGroupName(int groupId);
}
