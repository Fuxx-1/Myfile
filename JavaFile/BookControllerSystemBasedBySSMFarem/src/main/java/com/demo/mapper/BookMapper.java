package com.demo.mapper;

import com.demo.pojo.Books;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Fuxx-1
 * @date 2021年07月27日 11:33
 */
@Repository
public interface BookMapper {
    //增加一本书
    @Insert("insert into demo.books (bookID, bookName, bookCounts, detail) VALUES (#{bookID}, #{bookName}, #{bookCounts}, #{detail});")
    int addBook(Books book);

    //删除一本书
    @Delete("delete from demo.books where bookID = #{id};")
    int deleteBookById(int id);

    //更新一本书
    @Update("update demo.books set bookName = #{bookName}, bookCounts = #{bookCounts}, detail = #{detail} where bookID = #{bookID};")
    int updateBook(Books book);

    //查询一本书
    @Select("select * from demo.books where bookID = #{id} order by bookID;")
    Books queryBookById(int id);

    //查询一本书
    @Select("select * from demo.books where bookName like '%${name}%' order by bookID")
    List<Books> queryBookByName(String name);

    //查询全部的书
    @Select("select * from demo.books order by bookID;")
    List<Books> queryAllBook();

    //查询全部的书，分页api
    @Select("select * from demo.books order by bookID limit #{start}, #{limit};")
    List<Books> queryAllBookLimited(@Param("start") int start, @Param("limit") int limit);

}
