package com.nju.agiledev.dao;

import com.nju.agiledev.po.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDAO extends JpaRepository<Book,Integer> {
    Book findBookById(int id);

    /**
     * 获得目录下的所有书本信息
     * @param book_type
     * @return
     */
    @Query(value = "select * from book where book_type=?",nativeQuery = true)
    List<Book> findAllByBook_type(String book_type);

    /**
     * 根据书本名称和作者模糊搜索书本
     * @param keyword1
     * @param keyword2
     * @return
     */
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
