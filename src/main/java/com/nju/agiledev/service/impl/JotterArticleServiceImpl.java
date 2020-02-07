package com.nju.agiledev.service.impl;

import com.nju.agiledev.dao.JotterArticleDAO;
import com.nju.agiledev.po.JotterArticle;
import com.nju.agiledev.service.jotter.JotterArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @Author: chenyizong
 * @Date: 2020-02-06
 */
@Service
public class JotterArticleServiceImpl implements JotterArticleService {
    @Autowired
    JotterArticleDAO jotterArticleDAO;

    @Override
    public Page list(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return jotterArticleDAO.findAll(PageRequest.of(page, size, sort));
    }

    @Override
    public JotterArticle findById(int id) {
        return jotterArticleDAO.findById(id);
    }

    @Override
    public void addOrUpdate(JotterArticle jotterArticle) {
        jotterArticleDAO.save(jotterArticle);
    }

    @Override
    public void delete(int id) {
        jotterArticleDAO.deleteById(id);
    }
}
