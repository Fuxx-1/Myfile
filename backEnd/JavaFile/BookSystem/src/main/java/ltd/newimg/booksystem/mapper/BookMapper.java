package ltd.newimg.booksystem.mapper;

import ltd.newimg.booksystem.model.dto.BookInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * 增加一本书
     * 自增后的 id 会被填充在传入的对象中
     * @param bookInfoDTO 要添加的书籍信息，id 字段为空
     * @return 操作是否成功
     */
    Boolean addBook(BookInfoDTO bookInfoDTO);

    /**
     * 使用 id 删除书籍
     * @param id 要删除书籍的 id
     * @return 操作是否成功
     */
    Boolean delBookById(int id);

    /**
     * 更新书籍信息
     * @param bookInfoDTO 要更新的信息
     * @return 操作是否成功
     */
    Boolean updateBookInfo(BookInfoDTO bookInfoDTO);

    /**
     * 使用 name 作为关键字搜索书籍
     * @param name 关键字
     * @return 书籍列表
     */
    List<BookInfoDTO> queryByName(String name);
}
