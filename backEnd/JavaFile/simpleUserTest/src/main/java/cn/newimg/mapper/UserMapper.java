package cn.newimg.mapper;
import org.apache.ibatis.annotations.*;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:05
 */
@Mapper
public interface UserMapper {
    /**
     * 增加用户
     * @param username 用户名
     * @param password 用户密码
     * @return 是否成功
     */
    @Insert("INSERT INTO `user` " +
            "(username, password) " +
            "VALUES(#{username}, #{password});")
    Boolean addUser(String username, String password);

    /**
     * 删除用户
     * @param username 用户名
     * @return 是否成功
     */
    @Delete("DELETE FROM `user` " +
            "WHERE username = #{username};")
    Boolean delUser(String username);

    /**
     * 更新用户密码
     * @param username 用户名
     * @param password 密码
     * @return 是否成功
     */
    @Update("UPDATE `user` " +
            "SET password = #{password} " +
            "where username = #{username};")
    Boolean updatePassword(String username, String password);

    /**
     * 获取用户密码
     * @param username 用户名
     * @return 密码
     */
    @Select("SELECT password " +
            "FROM `user` " +
            "where username = #{username};")
    String queryPassword(String username);
}
