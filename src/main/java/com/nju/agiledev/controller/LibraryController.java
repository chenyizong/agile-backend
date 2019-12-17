package com.nju.agiledev.controller;

import com.nju.agiledev.po.Book;
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
    public Book addOrUpdate(@RequestBody Book book) throws Exception{
        bookService.addOrUpdate(book);
        return book;
    }

    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception{
        bookService.deleteById(book.getId());
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception{
        if(cid!=0){
            return bookService.listByCategory(cid);
        }else {
            return bookService.list();
        }
    }

    @CrossOrigin
    @PostMapping("/api/search")
    public List<Book> searchResult(@RequestBody Search s) throws Exception{
        if ("".equals(s.getKeywords())) {
            return bookService.list();
        } else {
            return bookService.search(s.getKeywords());
        }
    }

}
