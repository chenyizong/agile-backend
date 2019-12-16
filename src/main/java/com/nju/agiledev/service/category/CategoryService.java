package com.nju.agiledev.service.category;

import com.nju.agiledev.po.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 获得所有目录
     * @return
     */
    List<Category> list();

    /**
     * 根据目录id查询目录
     * @param id
     * @return
     */
    Category get(int id);

}
