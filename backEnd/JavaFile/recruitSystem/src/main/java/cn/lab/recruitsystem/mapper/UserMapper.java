package cn.lab.recruitsystem.mapper;

import cn.lab.recruitsystem.Model.dto.User;
import org.apache.ibatis.annotations.*;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:05
 */
@Mapper
public interface UserMapper {

    /**
     * 创建用户
     * @param userid 用户id
     * @return 是否添加成功
     */
    @Insert("insert into `user` (userid, create_time) " +
            "values (#{userid}, now());")
    boolean addUser(String userid);

    /**
     * 删除用户
     * @param userid 用户id
     * @return 是否删除成功
     */
    @Delete("delete from `user` " +
            "where userid = #{userid};")
    boolean delUser(String userid);

    /**
     * 更新用户权限
     * @param userid 用户id
     * @param auth 权限
     * @return 是否修改成功
     */
    @Update("update `user` set " +
            "auth = #{auth} " +
            "where userid = #{userid};")
    boolean updateAuth(String userid, Integer auth);

    /**
     * 更新用户信息
     * @param userid 用户id
     * @param name 姓名
     * @param gender 性别
     * @param major 班级
     * @param phone 手机
     * @param wish 方向
     * @return 是否修改成功
     */
    @Update("update `user` set " +
            "name = #{name}, gender = #{gender}, major = #{major}, phone = #{phone}, wish = #{wish} " +
            "where userid = #{userid};")
    boolean updateInf(String userid, String name, Boolean gender, String major, String phone, Integer wish);

    /**
     * 获取用户权限
     * @param userid 用户id
     * @return 用户权限
     */
    @Select("select auth " +
            "from `user` " +
            "where userid = #{userid}")
    Integer getAuth(String userid);

    /**
     * 查询用户信息
     * @param userid 要查询的用户id
     * @return 用户信息
     */
    @Select("select " +
            "userid, name, gender, major, email, phone, auth, wish, is_sign, auth, create_time, update_time " +
            "from `user` " +
            "where userid = #{userid}")
    User getUserInf(String userid);

    /**
     * 更改密码和邮箱，请确认使用该方法时已认证
     * @param userid 要改密码和邮箱的userid
     * @param password 新密码
     * @param email 新邮箱
     * @return 是否成功
     */
    @Update("update `user` set " +
            "password = #{password}, email = #{email} " +
            "where userid = #{userid};")
    Boolean updateMainInf(String userid, String password, String email);

    /**
     * 查询现在的密码
     * @param userid 用户id
     * @return 密码
     */
    @Select("select " +
            "password " +
            "from `user` " +
            "where userid = #{userid}")
    String queryPwd(String userid);

    /**
     * 签到
     * @param userid 用户id
     * @param is_sign 是否签到
     * @return 是否执行成功
     */
    @Update("update `user` set " +
            "is_sign = #{is_sign} " +
            "where userid = #{userid};")
    Boolean sign(String userid, Boolean is_sign);

    /**
     * 更新update_time时间
     * @param userid 用户id
     * @return 是否成功
     */
    @Update("update `user` set " +
            "update_time = now() " +
            "where userid = #{userid};")
    Boolean updateTime(String userid);

    /**
     * 更新openid
     * @param userid 用户id
     * @param openid 微信openid
     * @return 是否成功
     */
    @Update("update `user` set " +
            "wechat_id = #{openid} " +
            "where userid = #{userid};")
    Boolean updateOpenid(String userid, String openid);

    /**
     * 通过openid获取userid
     * @param userid 用户id
     * @return 是否成功
     */
    @Select("select userid " +
            "from `user` " +
            "where wechat_id = #{openid};")
    String getUseridByOpenid(String userid);
}
