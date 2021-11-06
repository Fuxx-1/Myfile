package com.demo.service;

import com.demo.mapper.BookMapper;
import com.demo.pojo.Books;

import java.util.List;

/**
 * @author Fuxx-1
 * @date 2021年07月27日 11:49
 */
public class BookServiceImpl implements BookService{
    //Service层调用Mapper层：组合Mapper
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryBookByName(String name) {
        return bookMapper.queryBookByName(name);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public List<Books> queryAllBookLimited(int start, int limit) {
        return bookMapper.queryAllBookLimited(start, limit);
    }
}
