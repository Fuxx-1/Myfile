package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.demo.pojo.Books;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fuxx-1
 * @date 2021年07月27日 16:15
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allbook")
    public String toAllPage() {
        return "allbook";
    }

    @RequestMapping("/addbook")
    public String toAddPage() {
        return "addbook";
    }

    @RequestMapping("/querybook")
    public String toQueryPage() {
        return "querybook";
    }

    @RequestMapping(value = "/updatebook")
    public String toUpdatePage(int id, Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("books", books);
        return "updatebook";
    }

    @RequestMapping(value = "/deletebook")
    public String toDeletePage(int id, Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("books", books);
        return "deletebook";
    }

    /**
     * 全部书籍
     *
     * @return 返回全部数据
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/all", produces = "application/json; charset=utf-8")
    public String all(int page, int limit) {
        List<Books> list = bookService.queryAllBook();
        List<Books> books = bookService.queryAllBookLimited((page - 1) * limit, limit);
        return getString(books, list.size());
    }

    /**
     * 用名称查询书籍
     *
     * @return 返回全部数据
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/queryname", produces = "application/json; charset=utf-8")
    public String queryname(String name) {
        List<Books> list = bookService.queryBookByName(name);
        return getString(list, list.size());
    }

    /**
     * 用ID查询书籍
     *
     * @return 返回全部数据
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/query/{id}", produces = "application/json; charset=utf-8")
    public String query(@PathVariable Integer id) {
        System.out.println(id);
        List<Books> list = new ArrayList<>();
        list.add(bookService.queryBookById(id));
        return getString(list, 1);
    }

    private String getString(Object book, int size) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", size);
        map.put("data", book);
        return JSON.toJSONString(map);
    }

    /**
     * 添加一本书
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/add")
    public String add(Books book) {
        System.out.println(bookService.addBook(book));
        return "redirect:/book/allbook";
    }

    /**
     * 修改
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/update")
    public String update(Books book) {
        System.out.println(bookService.updateBook(book));
        System.out.println(book.toString());
        return "redirect:/book/allbook";
    }

    /**
     * 删除
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/delete")
    public String update(int bookID) {
        System.out.println(bookService.deleteBookById(bookID));
        return "redirect:/book/allbook";
    }
}
