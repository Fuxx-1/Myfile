package com.demo.mapper;

import com.demo.pojo.Books;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author Fuxx-1
 * @date 2021年07月27日 15:37
 */
@Deprecated
public class BookMapperImpl extends SqlSessionDaoSupport implements BookMapper {

    @Override
    public int addBook(Books book) {
        return getSqlSession().getMapper(BookMapper.class).addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return getSqlSession().getMapper(BookMapper.class).deleteBookById(id);
    }

    @Override
    public int updateBook(Books book) {
        return getSqlSession().getMapper(BookMapper.class).updateBook(book);
    }

    @Override
    public Books queryBookById(int id) {
        return getSqlSession().getMapper(BookMapper.class).queryBookById(id);
    }

    @Override
    public List<Books> queryBookByName(String name) {
        return getSqlSession().getMapper(BookMapper.class).queryBookByName(name);
    }

    @Override
    public List<Books> queryAllBook() {
        return getSqlSession().getMapper(BookMapper.class).queryAllBook();
    }

    @Override
    public List<Books> queryAllBookLimited(int start, int end) {
        return getSqlSession().getMapper(BookMapper.class).queryAllBookLimited(start, end);
    }
}
