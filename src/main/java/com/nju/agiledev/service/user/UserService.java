package com.nju.agiledev.service.user;

import com.nju.agiledev.po.User;
import org.springframework.stereotype.Service;


public interface UserService {
    boolean isExist(String username);

    User getByName(String username);

    User getUser(String username,String password);

    void add(User user);


}
