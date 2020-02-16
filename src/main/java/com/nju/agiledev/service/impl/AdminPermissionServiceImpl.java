package com.nju.agiledev.service.impl;

import com.nju.agiledev.dao.AdminPermissionDAO;
import com.nju.agiledev.dao.AdminRolePermissionDAO;
import com.nju.agiledev.po.AdminPermission;
import com.nju.agiledev.po.AdminRole;
import com.nju.agiledev.po.AdminRolePermission;
import com.nju.agiledev.service.admin.AdminPermissionService;
import com.nju.agiledev.service.admin.AdminRolePermissionService;
import com.nju.agiledev.service.admin.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: chenyizong
 * @Date: 2020-02-13
 */
@Service
public class AdminPermissionServiceImpl implements AdminPermissionService {
    @Autowired
    AdminPermissionDAO adminPermissionDAO;
    @Autowired
    AdminRolePermissionDAO adminRolePermissionDAO;
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    @Override
    public AdminPermission findById(int id) {
        return adminPermissionDAO.findById(id);
    }

    @Override
    public List<AdminPermission> list() {
        return adminPermissionDAO.findAll();
    }

    @Override
    public boolean needFilter(String requestAPI) {
        List<AdminPermission> ps = adminPermissionDAO.findAll();
        for (AdminPermission adminPermission : ps) {
            // 这里我们进行前缀匹配，拥有父权限就拥有所有子权限
            if (requestAPI.startsWith(adminPermission.getUrl())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<AdminPermission> listPermsByRoleId(int rid) {
        List<AdminRolePermission> rps = adminRolePermissionDAO.findAllByRid(rid);
        List<AdminPermission> ps = new ArrayList<>();
        for (AdminRolePermission rp : rps) {
            ps.add(adminPermissionDAO.findById(rp.getPid()));
        }
        return ps;
    }

    @Override
    public Set<String> listPermissionsURLsByUser(String username) {
        List<AdminRole> roles = adminRoleService.listRolesByUser(username);
        Set<String> pURLs = new HashSet<>();
        for(AdminRole role:roles){
            List<AdminRolePermission> rps = adminRolePermissionService.findAllByRid(role.getId());
            for(AdminRolePermission rp :rps){
                pURLs.add(adminPermissionDAO.findById(rp.getPid()).getUrl());
            }
        }
        return pURLs;
    }
}
