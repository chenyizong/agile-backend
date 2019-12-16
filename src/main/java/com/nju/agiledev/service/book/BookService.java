package com.nju.agiledev.service.book;

import com.nju.agiledev.po.Book;

import java.util.List;

public interface BookService {
    /**
     * 获取所有书本列表
     * @return
     */
    List<Book> list();

    /**
     * 增加书本或修改书本信息
     * @param book
     */
    void addOrUpdate(Book book);

    /**
     * 根据书本id删除书本信息
     * @param id
     */
    void deleteById(int id);

    /**
     * 获取某个目录下的书本列表
     * @param cid
     * @return
     */
    List<Book> listByCategory(int cid);
}
