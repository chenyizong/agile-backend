package com.nju.agiledev.service.impl;

import com.nju.agiledev.dao.BookDAO;
import com.nju.agiledev.dao.Book_newDAO;
import com.nju.agiledev.dao.CommentsDAO;
import com.nju.agiledev.po.Book;
import com.nju.agiledev.po.Book_new;
import com.nju.agiledev.po.Category;
import com.nju.agiledev.po.Comments;
import com.nju.agiledev.service.book.BookService;
import com.nju.agiledev.service.category.CategoryService;
import com.nju.agiledev.service.comments.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    CommentsDAO commentsDAO;

    @Override
    public List<Comments> getTop20() {
        return commentsDAO.getTop20();
    }

    @Override
    public List<Comments> getCommentsByBook_id(int book_id) {
        return commentsDAO.getCommentsByBook_id(book_id);
    }
}
