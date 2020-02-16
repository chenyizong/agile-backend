package com.nju.agiledev.controller;

import com.nju.agiledev.po.AdminMenu;
import com.nju.agiledev.service.admin.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-11
 */
@RestController
public class MenuController {
    @Autowired
    AdminMenuService adminMenuService;

    @GetMapping("/api/menu")
    public List<AdminMenu> menu(){
        List<AdminMenu> menus = adminMenuService.getMenusByCurrentUser();
        return menus;
    }

    @GetMapping("/api/admin/role/menu")
    public List<AdminMenu> listAllMenus(){
        return adminMenuService.getMenusByRoleId(1);
    }
}

