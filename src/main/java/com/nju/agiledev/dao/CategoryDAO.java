package com.nju.agiledev.dao;

import com.nju.agiledev.po.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
    /**
     * JPA默认方法满足需求不新增方法
     */

}
