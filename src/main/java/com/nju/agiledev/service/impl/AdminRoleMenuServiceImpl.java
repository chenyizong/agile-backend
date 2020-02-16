package com.nju.agiledev.service.impl;

import com.nju.agiledev.dao.AdminRoleMenuDAO;
import com.nju.agiledev.po.AdminRoleMenu;
import com.nju.agiledev.service.admin.AdminRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-11
 */
@Service
public class AdminRoleMenuServiceImpl implements AdminRoleMenuService {
    @Autowired
    AdminRoleMenuDAO adminRoleMenuDAO;

    @Override
    public List<AdminRoleMenu> findAllByRid(int rid) {
        return adminRoleMenuDAO.findAllByRid(rid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAllByRid(int rid) {
        adminRoleMenuDAO.deleteAllByRid(rid);

    }

    @Override
    public void save(AdminRoleMenu adminRoleMenu) {
        adminRoleMenuDAO.save(adminRoleMenu);

    }
}
