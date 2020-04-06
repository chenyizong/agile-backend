package com.nju.agiledev.controller;

import com.nju.agiledev.po.BookWithComments;
import com.nju.agiledev.po.Book;
import com.nju.agiledev.po.Comments;
import com.nju.agiledev.result.Result;
import com.nju.agiledev.result.ResultFactory;
import com.nju.agiledev.service.book.BookService;
import com.nju.agiledev.service.comments.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zhuanggangqing
 * @Description:
 * @Date: Create in 4:10 下午 2020/4/5
 */
@RestController
public class HomeController {
    @Autowired
    BookService bookService;
    @Autowired
    CommentsService commentsService;

    @GetMapping("api/loadHomePage")
    public Result loadHomePage(){
        List<Comments> commentsList = commentsService.getTop20();
        Set<Integer> bookIDs = new HashSet<>();
        commentsList.forEach(x->{
            bookIDs.add(x.getBook_id());
        });
        List<BookWithComments> list = new ArrayList<>();
        bookIDs.forEach(x->{
            Book book = bookService.getBookByID(x);
            List<Comments> comments = commentsService.getCommentsByBook_id(x);
            BookWithComments each = new BookWithComments(book,comments.subList(0,3));
            list.add(each);
        });
        return ResultFactory.buildSuccessResult(list);
    }

}
