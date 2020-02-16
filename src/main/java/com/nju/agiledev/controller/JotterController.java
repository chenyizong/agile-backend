package com.nju.agiledev.controller;

import com.nju.agiledev.po.JotterArticle;
import com.nju.agiledev.result.Result;
import com.nju.agiledev.result.ResultFactory;
import com.nju.agiledev.service.jotter.JotterArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: chenyizong
 * @Date: 2020-02-06
 */
@RestController
public class JotterController {
    @Autowired
    JotterArticleService jotterArticleService;

    @PostMapping("api/admin/content/article")
    public Result saveArticle(@RequestBody JotterArticle jotterArticle) {
        jotterArticleService.addOrUpdate(jotterArticle);
        return ResultFactory.buildSuccessResult("保存成功");
    }

    @GetMapping("api/article/{size}/{page}")
    public Page listArticles(@PathVariable("size") int size, @PathVariable("page") int page) {
        return jotterArticleService.list(page - 1, size);
    }

    @GetMapping("api/article/{id}")
    public JotterArticle getOneArticle(@PathVariable("id") int id) {
        return jotterArticleService.findById(id);
    }

    @DeleteMapping("api/admin/content/article/{id}")
    public Result deleteArticle(@PathVariable("id") int id){
        jotterArticleService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }



}

