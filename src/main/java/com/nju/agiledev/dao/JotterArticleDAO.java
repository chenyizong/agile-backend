package com.nju.agiledev.dao;

import com.nju.agiledev.po.JotterArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: chenyizong
 * @Date: 2020-02-06
 */
public interface JotterArticleDAO extends JpaRepository<JotterArticle,Integer> {
    JotterArticle findById(int id);
}
