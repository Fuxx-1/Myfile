package ltd.newimg.booksystem.service;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.booksystem.model.vo.BookEntiretyVO;

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
     * @param bookEntirety 图书信息
     * @return 删除结果
     */
    JSONObject deleteBook(BookEntiretyVO bookEntirety);

    /**
     * 扣减库存
     * @param bookEntirety 图书信息
     * @return 扣减结果
     */
    JSONObject inventoryBookDeduction(BookEntiretyVO bookEntirety);

    /**
     * 使用关键字搜索图书
     * @param bookEntirety
     * @return 查询结果
     */
    JSONObject queryBook(BookEntiretyVO bookEntirety);
}
