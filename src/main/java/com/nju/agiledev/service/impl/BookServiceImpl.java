package com.nju.agiledev.service.impl;

import com.nju.agiledev.dao.BookDAO;
import com.nju.agiledev.dao.Book_newDAO;
import com.nju.agiledev.po.Book;
import com.nju.agiledev.po.Book_new;
import com.nju.agiledev.po.Category;
import com.nju.agiledev.service.book.BookService;
import com.nju.agiledev.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDAO bookDAO;
    @Autowired
    CategoryService categoryService;
    @Autowired
    Book_newDAO book_newDAO;

    /**
     * 获取所有书本列表
     *
     * @return
     */
    @Override
    public List<Book> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return bookDAO.findAll(sort);
    }

    /**
     * 增加书本或修改书本信息
     *
     * @param book
     */
    @Override
    public void addOrUpdate(Book book) {
        bookDAO.save(book);
    }

    /**
     * 根据书本id删除书本信息
     *
     * @param id
     */
    @Override
    public void deleteById(int id) {
        bookDAO.deleteById(id);

    }

    /**
     * 获取某个目录下的书本列表
     *
     * @param cid
     * @return
     */
    @Override
    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }

    @Override
    public List<Book> search(String keywords) {
        return bookDAO.findAllByTitleLikeOrAuthorLike('%'+keywords+'%','%'+keywords+'%');
    }

    @Override
    public Book_new getBookByID(int id) {
        return book_newDAO.findBookById(id);
    }
}
