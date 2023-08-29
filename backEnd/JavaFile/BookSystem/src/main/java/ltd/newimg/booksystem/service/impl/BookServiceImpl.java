package ltd.newimg.booksystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.booksystem.model.vo.BookEntiretyVO;
import ltd.newimg.booksystem.service.BookService;

public class BookServiceImpl implements BookService {
    /**
     * 增加图书
     *
     * @param bookEntirety 图书信息
     * @return 增加结果
     */
    @Override
    public JSONObject addBook(BookEntiretyVO bookEntirety) {
        return null;
    }

    /**
     * 更新图书
     *
     * @param bookEntirety 图书信息
     * @return 更新结果
     */
    @Override
    public JSONObject updateBook(BookEntiretyVO bookEntirety) {
        return null;
    }

    /**
     * 删除图书
     *
     * @param bookEntirety 图书信息
     * @return 删除结果
     */
    @Override
    public JSONObject deleteBook(BookEntiretyVO bookEntirety) {
        return null;
    }

    /**
     * 扣减库存
     *
     * @param bookEntirety 图书信息
     * @return 扣减结果
     */
    @Override
    public JSONObject inventoryBookDeduction(BookEntiretyVO bookEntirety) {
        return null;
    }

    /**
     * 使用关键字搜索图书
     *
     * @param bookEntirety
     * @return 查询结果
     */
    @Override
    public JSONObject queryBook(BookEntiretyVO bookEntirety) {
        return null;
    }
}
