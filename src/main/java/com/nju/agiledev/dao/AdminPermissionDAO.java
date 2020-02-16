package com.nju.agiledev.dao;

import com.nju.agiledev.po.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: chenyizong
 * @Date: 2020-02-12
 */
public interface AdminPermissionDAO extends JpaRepository<AdminPermission,Integer> {
    AdminPermission findById(int id);
}
