package com.nju.agiledev.service.impl;

import com.nju.agiledev.dao.CommentsDAO;
import com.nju.agiledev.po.Comments;
import com.nju.agiledev.service.comments.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
