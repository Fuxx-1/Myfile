package com.demo.mapper;

import com.demo.pojo.Friend;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendMapper {
    /**
     * 增加好友信息
     * @param friend 传入信息
     * @return 是否增加成功
     */
    @Insert("insert demo.friendinfo(myId, friendId, isadopted) values (#{myId}, #{friendId}, 0)")
    boolean addFriendInfo(int myId, int friendId);

    /**
     * 删除好友信息
     * @param friend 信息
     * @return 是否删除成功
     */
    @Delete("delete from demo.friendinfo where (myId = #{myId} and friendId = #{friendId}) or (myId = #{friendId} and friendId = #{myId})")
    boolean deleteFriendInfo(Friend friend);

    /**
     * 查询好友信息
     * @param id 用户id
     * @return 信息列表
     */
    @Select("select * from demo.friendinfo where myid = #{id} or friendid = #{id}")
    List<Friend> queryFriendInfo(int id);

    /**
     * 更新信息
     * @param friend 传入对象
     * @return 是否更改成功
     */
    @Update("update demo.friendinfo set isadopted = 1 where friendId = #{myId} and myId = #{friendId}")
    boolean updateState(Friend friend);
}
