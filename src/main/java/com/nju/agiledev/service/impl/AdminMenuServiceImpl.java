package com.nju.agiledev.service.impl;

import com.nju.agiledev.dao.AdminMenuDAO;
import com.nju.agiledev.po.AdminMenu;
import com.nju.agiledev.po.AdminRoleMenu;
import com.nju.agiledev.po.AdminUserRole;
import com.nju.agiledev.po.User;
import com.nju.agiledev.service.admin.AdminMenuService;
import com.nju.agiledev.service.admin.AdminRoleMenuService;
import com.nju.agiledev.service.admin.AdminUserRoleService;
import com.nju.agiledev.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-11
 */
@Service
public class AdminMenuServiceImpl implements AdminMenuService {
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleMenuService adminRoleMenuService;
    @Autowired
    AdminMenuDAO adminMenuDAO;

    @Override
    public List<AdminMenu> getMenusByCurrentUser() {
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        System.out.println(username);
        User user = userService.getByName(username);
        List<AdminUserRole> userRoleList = adminUserRoleService.listAllByUid(user.getId());
        List<AdminMenu> menus = new ArrayList<>();
        for (AdminUserRole userRole : userRoleList) {
            List<AdminRoleMenu> rms = adminRoleMenuService.findAllByRid(userRole.getRid());
            for (AdminRoleMenu rm : rms) {
                AdminMenu adminMenu = adminMenuDAO.findById(rm.getMid());
                boolean isExist = false;
                for (AdminMenu m : menus) {
                    if (m.getId() == adminMenu.getId()) {
                        isExist = true;
                    }
                }
                if (!isExist) {
                    menus.add(adminMenu);
                }
            }
        }
        handleMenus(menus);

        return menus;
    }

    public void handleMenus(List<AdminMenu> menus) {
        for (AdminMenu menu : menus) {
            menu.setChildren(getAllByParentId(menu.getId()));
        }
        Iterator<AdminMenu> iterator = menus.iterator();
        while(iterator.hasNext()){
            AdminMenu menu = iterator.next();
            if(menu.getParentId()!=0){
                iterator.remove();
            }
        }
    }

    public List<AdminMenu> getAllByParentId(int parentId) {
        return adminMenuDAO.findAllByParentId(parentId);
    }

    @Override
    public List<AdminMenu> getMenusByRoleId(int rid) {
        List<AdminMenu> menus = new ArrayList<>();
        List<AdminRoleMenu> rms = adminRoleMenuService.findAllByRid(rid);
        for(AdminRoleMenu rm:rms){
            AdminMenu menu = adminMenuDAO.findById(rm.getMid());
            menus.add(menu);
        }
        handleMenus(menus);
        return menus;
    }
}
