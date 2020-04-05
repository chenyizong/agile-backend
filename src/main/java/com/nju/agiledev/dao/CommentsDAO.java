package com.nju.agiledev.dao;

import com.nju.agiledev.po.Book;
import com.nju.agiledev.po.Comments;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: zhuanggangqing
 * @Description:
 * @Date: Create in 4:24 下午 2020/4/5
 */
public interface CommentsDAO extends JpaRepository<Comments,Integer> {

    @Query(value = "select * from Comments c order by praise DESC limit 20", nativeQuery = true)
    List<Comments> getTop20();

    @Query(value = "select * from Comments c where book_id = ?", nativeQuery = true)
    List<Comments> getCommentsByBook_id(int book_id);
}
