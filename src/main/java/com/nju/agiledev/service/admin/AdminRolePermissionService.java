package com.nju.agiledev.service.admin;

import com.nju.agiledev.po.AdminPermission;
import com.nju.agiledev.po.AdminRolePermission;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-13
 */
public interface AdminRolePermissionService {
    List<AdminRolePermission> findAllByRid(int rid);

    void savePermChanges(int rid,List<AdminPermission> ps);

}
