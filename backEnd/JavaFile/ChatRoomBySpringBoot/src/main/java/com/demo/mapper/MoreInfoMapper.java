package com.demo.mapper;

import com.demo.pojo.MoreInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MoreInfoMapper {
    /**
     * 增加信息
     * @param moreinfo 增加的信息
     * @return 操作是否成功
     */
    @Insert("insert into demo.moreinfo (id, avatar, nickname, personalsign) VALUE (#{id},#{avatar},#{nickName},#{personalSign})")
    boolean addMoreInfo(MoreInfo moreinfo);

    /**
     * 删除信息
     * @param id 删除信息的id
     * @return 操作是否成功
     */
    @Delete("delete from demo.moreinfo where id = #{id}")
    boolean deleteMoreInfo(int id);

    /**
     * 更新信息
     * @param moreinfo 更新的信息
     * @return 操作是否成功
     */
    @Update("update demo.moreinfo set avatar=#{avatar}, personalsign=#{personalSign}, nickname=#{nickName} where id = #{id}")
    boolean updateMoreInfo(MoreInfo moreinfo);

    /**
     * 查询信息
     * @param id 查询的id
     * @return 查询结果
     */
    @Select("select * from demo.moreinfo where id = #{id}")
    MoreInfo queryMoreInfo(int id);
}
