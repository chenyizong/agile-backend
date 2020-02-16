package com.nju.agiledev.service.admin;

import com.nju.agiledev.po.AdminPermission;

import java.util.List;
import java.util.Set;

/**
 * @Author: chenyizong
 * @Date: 2020-02-12
 */
public interface AdminPermissionService {
    AdminPermission findById(int id);

    List<AdminPermission> list();

    /**
     * 判断用户请求的接口是否在权限列表中
     */
    boolean needFilter(String requestAPI);

    List<AdminPermission> listPermsByRoleId(int rid);

    Set<String> listPermissionsURLsByUser(String username);

}
