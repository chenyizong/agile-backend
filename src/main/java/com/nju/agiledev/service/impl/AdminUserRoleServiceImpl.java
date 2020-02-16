package com.nju.agiledev.service.impl;

import com.nju.agiledev.dao.AdminUserRoleDAO;
import com.nju.agiledev.po.AdminRole;
import com.nju.agiledev.po.AdminUserRole;
import com.nju.agiledev.service.admin.AdminUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-11
 */
@Service
public class AdminUserRoleServiceImpl implements AdminUserRoleService {
    @Autowired
    AdminUserRoleDAO adminUserRoleDAO;

    @Override
    public List<AdminUserRole> listAllByUid(int uid) {
        return adminUserRoleDAO.findAllByUid(uid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRoleChanges(int uid, List<AdminRole> roles) {
        adminUserRoleDAO.deleteAllByUid(uid);
        for(AdminRole role:roles){
            AdminUserRole ur = new AdminUserRole();
            ur.setUid(uid);
            ur.setRid(role.getId());
            adminUserRoleDAO.save(ur);
        }
    }
}
