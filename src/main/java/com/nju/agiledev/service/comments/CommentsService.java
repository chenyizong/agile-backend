package com.nju.agiledev.service.comments;

import com.nju.agiledev.po.Comments;

import java.util.List;

public interface CommentsService {
    List<Comments> getTop20();

    List<Comments> getCommentsByBook_id(int book_id);
}
