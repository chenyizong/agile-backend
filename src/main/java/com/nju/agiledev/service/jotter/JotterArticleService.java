package com.nju.agiledev.service.jotter;

import com.nju.agiledev.po.JotterArticle;
import org.springframework.data.domain.Page;

/**
 * @Author: chenyizong
 * @Date: 2020-02-06
 */
public interface JotterArticleService {
    /**
     * 实现分页功能（Spring Data提供的Page类）
     *
     * @param page
     * @param size
     * @return
     */
    Page list(int page, int size);

    /**
     * 根据id查找文章
     *
     * @param id
     * @return
     */
    JotterArticle findById(int id);

    /**
     * 更新文章
     *
     * @param jotterArticle
     */
    void addOrUpdate(JotterArticle jotterArticle);

    /**
     * 删除文章
     *
     * @param id
     */
    void delete(int id);


}
