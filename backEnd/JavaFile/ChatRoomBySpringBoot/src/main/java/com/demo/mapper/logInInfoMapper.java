package com.demo.mapper;

import com.demo.pojo.logInInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Fuxx-1
 * @date 2021年09月21日 23:01
 */

@Mapper
public interface logInInfoMapper {
    /**
     * 用id查询密码
     * @param id 用户id
     * @return 密码
     */
    @Select("select * from demo.logininfo where id = #{id} ")
    logInInfo querypwd(int id);

    /**
     * 注册
     * @param logInInfo 传入注册参数
     * @return 操作是否成功
     */
    @Insert("insert into demo.logininfo(id, password) VALUE (#{id},#{password})")
    boolean addlogininfo(logInInfo logInInfo);

    /**
     * 更改密码
     * @param logInInfo 传入用户id和新密码
     * @return 密码是否修改成功
     */
    @Update("update demo.logininfo set password = #{password} where id = #{id}")
    boolean updatePassword(logInInfo logInInfo);


}
