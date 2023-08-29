package ltd.newimg.booksystem.mapper;

import ltd.newimg.booksystem.model.dto.UserDTO;
import ltd.newimg.booksystem.model.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 增加用户
     * @param user 要增加的用户信息
     * @return 是否成功
     */
    Boolean addUser(UserVO user);

    /**
     * 使用 id 删除用户
     * @param id 关键字
     * @return 是否成功
     */
    Boolean deleteById(Integer id);

    /**
     * 更新用户信息
     * @param user 要更新的用户信息
     * @return 是否成功
     */
    Boolean update(UserDTO user);

    /**
     * 查询用户信息
     * @param name 查询关键字
     * @return 用户信息
     */
    UserDTO queryByName(String name);

    /**
     * 查询用户信息
     * @param id 查询关键字
     * @return 用户信息
     */
    UserDTO queryById(Integer id);

}
