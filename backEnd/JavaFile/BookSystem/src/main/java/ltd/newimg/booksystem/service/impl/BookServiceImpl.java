package ltd.newimg.booksystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.booksystem.Util.ReturnUtil;
import ltd.newimg.booksystem.Util.en.ReturnCodeEnum;
import ltd.newimg.booksystem.config.UserHolder;
import ltd.newimg.booksystem.mapper.BookMapper;
import ltd.newimg.booksystem.model.dto.BookEntiretyDTO;
import ltd.newimg.booksystem.model.dto.BookInfoDTO;
import ltd.newimg.booksystem.model.vo.BookEntiretyVO;
import ltd.newimg.booksystem.model.vo.BookQueryByNameVO;
import ltd.newimg.booksystem.model.vo.UserVO;
import ltd.newimg.booksystem.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;

    /**
     * 增加图书
     *
     * @param bookEntirety 图书信息
     * @return 增加结果
     */
    @Override
    public JSONObject addBook(BookEntiretyVO bookEntirety) {
        // 设置创建用户
        Integer id = UserHolder.getUser().getId();
        if (id == null) return ReturnUtil.returnObj(ReturnCodeEnum.ACCESS_DENIED, null);
        bookEntirety.setCreateId(id);
        // 增加书籍信息
        BookInfoDTO bookInfDTO = bookEntirety.toBookInfDTO();
        Boolean addBookResult = bookMapper.addBookInf(bookInfDTO);
        // 更新id
        bookEntirety.setId(bookInfDTO.getId());
        // 创建详情
        Boolean updateBookDetailResult = bookMapper.addBookDetail(bookEntirety.toBookDetailDTO());
        if (addBookResult && updateBookDetailResult) {
            // 增加成功
            return ReturnUtil.returnObj(ReturnCodeEnum.SUCCESS, new HashMap<String, Object>() {{
                put("id", bookInfDTO.getId());
            }});
        } else {
            // 增加失败
            return ReturnUtil.returnObj(ReturnCodeEnum.SYSTEM_FAILED, null);
        }
    }

    /**
     * 更新图书
     *
     * @param bookEntirety 图书信息
     * @return 更新结果
     */
    @Override
    public JSONObject updateBook(BookEntiretyVO bookEntirety) {
        // 获取并更新数据
        BookEntiretyDTO bookEntiretyDTO = bookMapper.queryById(bookEntirety.getId());
        bookEntiretyDTO.updateWith(bookEntirety);
        // 刷入数据库
        Boolean updateBookInfoResult = bookMapper.updateBookInfo(bookEntiretyDTO.toBookInfDTO());
        Boolean updateBookDetailResult = bookMapper.updateBookDetail(bookEntiretyDTO.toBookDetailDTO());
        if (updateBookInfoResult && updateBookDetailResult) {
            return ReturnUtil.returnObj(ReturnCodeEnum.SUCCESS, null);
        } else if (updateBookInfoResult || updateBookDetailResult) {
            return ReturnUtil.returnObj(ReturnCodeEnum.PART_SUCCESS, null);
        } else {
            return ReturnUtil.returnObj(ReturnCodeEnum.SYSTEM_FAILED, null);
        }
    }

    /**
     * 删除图书
     *
     * @param id 图书id
     * @return 删除结果
     */
    @Override
    public JSONObject deleteBook(Integer id) {
        Boolean delBookResult = bookMapper.delBookById(id);
        if (delBookResult) {
            return ReturnUtil.returnObj(ReturnCodeEnum.SUCCESS, null);
        } else {
            return ReturnUtil.returnObj(ReturnCodeEnum.SYSTEM_FAILED, null);
        }
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
     * @param bookQuery 图书名
     * @return 查询结果
     */
    @Override
    public JSONObject queryBook(BookQueryByNameVO bookQuery) {
        bookQuery.setName('%' + bookQuery.getName() + '%');
        List<BookInfoDTO> bookInfos = bookMapper.queryByName(bookQuery);
        return ReturnUtil.returnObj(ReturnCodeEnum.SUCCESS, new HashMap<String, Object>() {{
            put("bookInfos", bookInfos);
        }});
    }

    /**
     * 使用id搜索图书
     *
     * @param id 图书id
     * @return 查询结果
     */
    @Override
    public JSONObject queryBook(Integer id) {
        BookEntiretyDTO bookEntiretyDTO = bookMapper.queryById(id);
        return ReturnUtil.returnObj(ReturnCodeEnum.SUCCESS, bookEntiretyDTO);
    }
}
