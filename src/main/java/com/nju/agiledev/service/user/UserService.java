package com.nju.agiledev.service.user;

import com.nju.agiledev.po.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    boolean isExist(String username);

    List<User> list();

    User getByName(String username);

    User getUser(String username,String password);

    void add(User user);
}
