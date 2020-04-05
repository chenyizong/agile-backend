package com.nju.agiledev.service.book;

import com.nju.agiledev.po.Book;
import com.nju.agiledev.po.Book_new;

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

    /**
     * 模糊搜索书名或者作者名
     * @param keywords
     * @return
     */
    List<Book> search(String keywords);

    Book_new getBookByID(int id);
}
