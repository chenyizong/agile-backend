package com.nju.agiledev.dao;

import com.nju.agiledev.po.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: chenyizong
 * @Date: 2020-02-12
 */
public interface AdminRoleDAO extends JpaRepository<AdminRole, Integer> {
    AdminRole findById(int id);
}
