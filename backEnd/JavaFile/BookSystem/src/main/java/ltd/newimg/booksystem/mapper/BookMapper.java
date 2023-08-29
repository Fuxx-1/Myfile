package ltd.newimg.booksystem.mapper;

import ltd.newimg.booksystem.model.dto.BookDetailDTO;
import ltd.newimg.booksystem.model.dto.BookEntiretyDTO;
import ltd.newimg.booksystem.model.dto.BookInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * 增加一本书
     * 自增后的 id 会被填充在传入的对象中
     * @param bookInfo 要添加的书籍信息，id 字段为空
     * @return 操作是否成功
     */
    Boolean addBook(BookInfoDTO bookInfo);

    /**
     * 使用 id 删除书籍
     * @param id 要删除书籍的 id
     * @return 操作是否成功
     */
    Boolean delBookById(int id);

    /**
     * 更新书籍信息
     * @param bookInfo 要更新的信息
     * @return 操作是否成功
     */
    Boolean updateBookInfo(BookInfoDTO bookInfo);

    /**
     * 更新书籍详情
     * @param bookDetail 要更新的详情
     * @return 操作是否成功
     */
    Boolean updateBookDetail(BookDetailDTO bookDetail);

    /**
     * 使用 name 作为关键字搜索书籍
     * @param name 关键字
     * @return 书籍信息列表
     */
    List<BookInfoDTO> queryByName(String name);

    /**
     * 使用 id 获取书籍信息及详情
     * @param id 书籍 id
     * @return 书籍信息及详情
     */
    BookEntiretyDTO queryById(Integer id);

}
