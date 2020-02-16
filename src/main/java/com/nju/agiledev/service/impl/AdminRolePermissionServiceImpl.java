package com.nju.agiledev.service.impl;

import com.nju.agiledev.dao.AdminRolePermissionDAO;
import com.nju.agiledev.po.AdminPermission;
import com.nju.agiledev.po.AdminRolePermission;
import com.nju.agiledev.service.admin.AdminRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-13
 */
@Service
public class AdminRolePermissionServiceImpl implements AdminRolePermissionService {
    @Autowired
    AdminRolePermissionDAO adminRolePermissionDAO;

    @Override
    public List<AdminRolePermission> findAllByRid(int rid) {
        return adminRolePermissionDAO.findAllByRid(rid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePermChanges(int rid, List<AdminPermission> ps) {
        adminRolePermissionDAO.deleteAllByRid(rid);

        for (AdminPermission p : ps) {
            AdminRolePermission adminRolePermission = new AdminRolePermission();
            adminRolePermission.setPid(p.getId());
            adminRolePermission.setRid(rid);
            adminRolePermissionDAO.save(adminRolePermission);
        }


    }
}
