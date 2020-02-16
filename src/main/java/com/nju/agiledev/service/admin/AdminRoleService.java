package com.nju.agiledev.service.admin;

import com.nju.agiledev.po.AdminRole;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-13
 */
public interface AdminRoleService {
    List<AdminRole> list();

    AdminRole findById(int id);

    void addOrUpdate(AdminRole adminRole);

    List<AdminRole> listRolesByUser(String username);
}
