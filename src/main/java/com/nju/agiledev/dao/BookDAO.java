package com.nju.agiledev.dao;

import com.nju.agiledev.po.Book;
import com.nju.agiledev.po.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDAO extends JpaRepository<Book,Integer> {

    /**
     * 获得目录下的所有书本信息
     * @param category
     * @return
     */
    List<Book> findAllByCategory(Category category);

    /**
     * 根据书本名称和作者模糊搜索书本
     * @param keyword1
     * @param keyword2
     * @return
     */
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1,String keyword2);
}
