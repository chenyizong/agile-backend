package com.nju.agiledev.dao;

import com.nju.agiledev.po.AdminRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-12
 */
public interface AdminRolePermissionDAO extends JpaRepository<AdminRolePermission,Integer> {
    List<AdminRolePermission> findAllByRid(int rid);
    void deleteAllByRid(int rid);
}
