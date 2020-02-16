package com.nju.agiledev.service.admin;

import com.nju.agiledev.po.AdminRoleMenu;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-11
 */
public interface AdminRoleMenuService {
    /**
     * 根据rid查找角色菜单项
     * @param rid
     * @return
     */
    List<AdminRoleMenu> findAllByRid(int rid);

    void deleteAllByRid(int rid);

    void save(AdminRoleMenu adminRoleMenu);

}
