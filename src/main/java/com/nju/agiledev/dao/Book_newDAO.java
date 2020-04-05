package com.nju.agiledev.dao;

import com.nju.agiledev.po.Book;
import com.nju.agiledev.po.Book_new;
import com.nju.agiledev.po.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Book_newDAO extends JpaRepository<Book_new,Integer> {
    Book_new findBookById(int id);
}
