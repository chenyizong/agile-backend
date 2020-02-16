package com.nju.agiledev.service.impl;


import com.nju.agiledev.dao.AdminRoleDAO;
import com.nju.agiledev.po.AdminMenu;
import com.nju.agiledev.po.AdminPermission;
import com.nju.agiledev.po.AdminRole;
import com.nju.agiledev.po.AdminUserRole;
import com.nju.agiledev.service.admin.AdminMenuService;
import com.nju.agiledev.service.admin.AdminPermissionService;
import com.nju.agiledev.service.admin.AdminRoleService;
import com.nju.agiledev.service.admin.AdminUserRoleService;
import com.nju.agiledev.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-13
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    @Autowired
    AdminRoleDAO adminRoleDAO;
    @Autowired
    AdminMenuService adminMenuService;
    @Autowired
    AdminPermissionService adminPermissionService;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;

    @Override
    public List<AdminRole> list() {
        List<AdminRole> rs = adminRoleDAO.findAll();
        List<AdminMenu> ms;
        List<AdminPermission> ps;
        for (AdminRole r : rs) {
            ms = adminMenuService.getMenusByRoleId(r.getId());
            ps = adminPermissionService.listPermsByRoleId(r.getId());
            r.setMenus(ms);
            r.setPerms(ps);
        }
        return rs;
    }

    @Override
    public AdminRole findById(int id) {
        return adminRoleDAO.findById(id);
    }

    @Override
    public void addOrUpdate(AdminRole adminRole) {
        adminRoleDAO.save(adminRole);
    }

    @Override
    public List<AdminRole> listRolesByUser(String username) {
        int uid = userService.getByName(username).getId();
        List<AdminUserRole> urs = adminUserRoleService.listAllByUid(uid);
        List<AdminRole> rs = new ArrayList<>();
        for(AdminUserRole ur :urs){
            rs.add(adminRoleDAO.findById(ur.getRid()));
        }
        return rs;
    }
}
