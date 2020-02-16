package com.nju.agiledev.service.admin;

import com.nju.agiledev.po.AdminRole;
import com.nju.agiledev.po.AdminUserRole;

import java.util.List;

/**
 * @Author: chenyizong
 * @Date: 2020-02-11
 */
public interface AdminUserRoleService {
    /**
     * 根据userid获得用户的所有角色
     * @param uid
     * @return
     */
    List<AdminUserRole> listAllByUid(int uid);

    void saveRoleChanges(int uid,List<AdminRole> roles);
}
