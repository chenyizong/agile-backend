package com.nju.agiledev.service.impl;

import com.nju.agiledev.dao.CategoryDAO;
import com.nju.agiledev.po.Category;
import com.nju.agiledev.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    /**
     * 获得所有目录
     * @return
     */
    @Override
    public List<Category> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }

    /**
     * 根据目录id查询目录
     * @param id
     * @return
     */
    @Override
    public Category get(int id) {
        Category category = categoryDAO.findById(id).orElse(null);
        return category;
    }
}
