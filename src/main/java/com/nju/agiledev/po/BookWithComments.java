package com.nju.agiledev.po;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author: zhuanggangqing
 * @Description:
 * @Date: Create in 5:02 下午 2020/4/5
 */
@AllArgsConstructor
@Data
public class BookWithComments {
    Book_new book;
    List<Comments> comments;
}
