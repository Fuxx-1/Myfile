package com.demo.service;

import com.demo.pojo.Books;

import java.util.List;

public interface BookService {
    //增加一本书
    int addBook(Books book);

    //删除一本书
    int deleteBookById(int id);

    //更新一本书
    int updateBook(Books book);

    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBook();

    //查询一本书
    List<Books> queryBookByName(String name);

    //查询全部的书，分页
    List<Books> queryAllBookLimited(int start, int limit);

}
