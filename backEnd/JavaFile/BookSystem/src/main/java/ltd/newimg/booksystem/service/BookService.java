package ltd.newimg.booksystem.service;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.booksystem.model.vo.BookEntiretyVO;
import ltd.newimg.booksystem.model.vo.BookQueryByNameVO;

public interface BookService {
    /**
     * 增加图书
     * @param bookEntirety 图书信息
     * @return 增加结果
     */
    JSONObject addBook(BookEntiretyVO bookEntirety);

    /**
     * 更新图书
     * @param bookEntirety 图书信息
     * @return 更新结果
     */
    JSONObject updateBook(BookEntiretyVO bookEntirety);

    /**
     * 删除图书
     * @param id 图书id
     * @return 删除结果
     */
    JSONObject deleteBook(Integer id);

    /**
     * 扣减库存
     * @param bookEntirety 图书信息
     * @return 扣减结果
     */
    JSONObject inventoryBookDeduction(BookEntiretyVO bookEntirety);

    /**
     * 使用关键字搜索图书
     * @param bookQuery 图书名
     * @return 查询结果
     */
    JSONObject queryBook(BookQueryByNameVO bookQuery);

    /**
     * 使用id搜索图书
     * @param id 图书id
     * @return 查询结果
     */
    JSONObject queryBook(Integer id);
}
