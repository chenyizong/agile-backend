package com.nju.agiledev.controller;

import com.nju.agiledev.po.Book;
import com.nju.agiledev.po.BookType;
import com.nju.agiledev.po.Search;
import com.nju.agiledev.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @CrossOrigin
    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @CrossOrigin
    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByBookType(@PathVariable int cid) throws Exception {
        String[] types = {"全部","小说","言情","历史","教育","旅行","散文","哲学","旅行","美食","商业","编程"};
        if (cid==0) {
            return bookService.list();

        } else {
            return bookService.listByBookType(types[cid]);
        }
    }

    @CrossOrigin
    @PostMapping("/api/search")
    public List<Book> searchResult(@RequestBody Search s) throws Exception {
        if ("".equals(s.getKeywords())) {
            return bookService.list();
        } else {
            return bookService.search(s.getKeywords());
        }
    }

}
