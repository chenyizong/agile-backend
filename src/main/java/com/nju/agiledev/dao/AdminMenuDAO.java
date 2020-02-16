package com.nju.agiledev.dao;

import com.nju.agiledev.po.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-11
 */
public interface AdminMenuDAO extends JpaRepository<AdminMenu,Integer> {
    AdminMenu findById(int id);

    List<AdminMenu> findAllByParentId(int parentId);
}
