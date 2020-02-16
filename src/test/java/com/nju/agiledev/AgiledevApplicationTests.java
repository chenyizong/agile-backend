package com.nju.agiledev;

import com.nju.agiledev.controller.LibraryController;
import com.nju.agiledev.controller.MenuController;
import com.nju.agiledev.dao.BookDAO;
import com.nju.agiledev.dao.JotterArticleDAO;
import com.nju.agiledev.po.AdminMenu;
import com.nju.agiledev.po.Book;
import com.nju.agiledev.po.JotterArticle;
import com.nju.agiledev.service.book.BookService;
import com.nju.agiledev.service.jotter.JotterArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.*;
import java.util.List;

@SpringBootTest
class AgiledevApplicationTests {
    @Autowired
    BookService bookService;
    @Autowired
    BookDAO bookDAO;
    @Autowired
    LibraryController libraryController;

    @Autowired
    JotterArticleService jotterArticleService;
    @Autowired
    JotterArticleDAO jotterArticleDAO;

    @Autowired
    MenuController menuController;

    @Test
    void contextLoads() {
    }

    @Test
    void getBookListByCategory() {
        List<Book> bookList = null;
        try {
            bookList = libraryController.listByCategory(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bookList);
    }

    @Test
    void getArticlesList(){
        JotterArticle jotterArticle = jotterArticleDAO.findById(1);
        System.out.println(jotterArticle.getArticleTitle());
    }

    @Test
    void getmenulist(){
        List<AdminMenu> menus = menuController.menu();
        System.out.println(menus.get(0));
    }


}