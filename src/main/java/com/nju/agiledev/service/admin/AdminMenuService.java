package com.nju.agiledev.service.admin;

import com.nju.agiledev.po.AdminMenu;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-11
 */
public interface AdminMenuService {
    /**
     * 根据当前用户id查找可访问的菜单项
     * @return
     */
    List<AdminMenu> getMenusByCurrentUser();

    /**
     * 根据角色id查找可访问的菜单项
     * @return
     */
    List<AdminMenu> getMenusByRoleId(int rid);


}
