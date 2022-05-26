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
     * @param name 用户姓名
     * @return 是否添加成功
     */
    @Insert("insert into `user` (userid, name) " +
            "values (#{userid}, #{name});")
    boolean addUser(String userid, String name);

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
    boolean updateAuth(String userid, String auth);

    /**
     * 更新用户信息
     * @param userid 用户id
     * @param password 密码
     * @param email 邮箱
     * @param phone 手机
     * @return 是否修改成功
     */
    @Update("update `user` set " +
            "password = #{password}, email = #{email}, phone = #{phone} " +
            "where userid = #{userid};")
    boolean updateInf(String userid, String password, String email, String phone);

    /**
     * 获取用户权限
     * @param userid 用户id
     * @return 用户权限
     */
    @Select("select auth " +
            "from `user` " +
            "where userid = #{userid}")
    int getAuth(String userid);

    /**
     *
     * @param userid
     * @return
     */
    @Select("select " +
            "name, password, email, phone, auth, wish, create_time, update_time " +
            "from `user` " +
            "where userid = #{userid}")
    User getUserInf(String userid);


}
