package com.nju.agiledev.service.impl;

import com.nju.agiledev.dao.UserDAO;
import com.nju.agiledev.po.User;
import com.nju.agiledev.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public boolean isExist(String username) {
        User user = userDAO.findByUsername(username);
        return user != null;
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
