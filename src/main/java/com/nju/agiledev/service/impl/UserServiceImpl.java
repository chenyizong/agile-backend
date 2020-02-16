package com.nju.agiledev.service.impl;

import com.nju.agiledev.dao.UserDAO;
import com.nju.agiledev.po.AdminRole;
import com.nju.agiledev.po.User;
import com.nju.agiledev.service.admin.AdminRoleService;
import com.nju.agiledev.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: chenyizong
 * @Date: 2020-02-06
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    AdminRoleService adminRoleService;

    @Override
    public boolean isExist(String username) {
        User user = userDAO.findByUsername(username);
        return user != null;
    }

    @Override
    public List<User> list() {
        List<User> users =  userDAO.list();
        List<AdminRole> roles;
        for (User user : users) {
            roles = adminRoleService.listRolesByUser(user.getUsername());
            user.setRoles(roles);
        }
        return users;
    }

    @Override
    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public User getUser(String username, String password) {
        return userDAO.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public void add(User user) {
        userDAO.save(user);

    }
}
