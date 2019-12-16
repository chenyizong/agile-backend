package com.nju.agiledev;

import com.nju.agiledev.dao.BookDAO;
import com.nju.agiledev.po.Book;
import com.nju.agiledev.service.book.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AgiledevApplicationTests {
    @Autowired
    BookService bookService;
    @Autowired
    BookDAO bookDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void getBookList() {
        List<Book> bookList = bookDAO.findAll();
        System.out.println(bookList);
    }
}
