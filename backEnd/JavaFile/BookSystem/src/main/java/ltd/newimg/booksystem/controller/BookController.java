package ltd.newimg.booksystem.controller;

import ltd.newimg.booksystem.model.vo.BookEntiretyVO;
import ltd.newimg.booksystem.model.vo.BookQueryByNameVO;
import ltd.newimg.booksystem.service.BookService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    @Resource
    BookService bookService;

    @PostMapping("/query")
    String queryBook(@NonNull @RequestBody BookQueryByNameVO bookQueryByName) {
        return bookService.queryBook(bookQueryByName).toJSONString();
    }

    @PostMapping("")
    String addBook(@RequestBody BookEntiretyVO bookEntirety) {
        return bookService.addBook(bookEntirety).toJSONString();
    }

    @DeleteMapping("")
    String deleteBook(@NonNull Integer id) {
        return bookService.deleteBook(id).toJSONString();
    }

    @PatchMapping("")
    String updateBook(@RequestBody BookEntiretyVO bookEntirety) {
        return bookService.updateBook(bookEntirety).toJSONString();
    }

    @GetMapping("")
    String queryBook(@NonNull Integer id) {
        return bookService.queryBook(id).toJSONString();
    }
}
