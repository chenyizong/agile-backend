package com.nju.agiledev.dao;

import com.nju.agiledev.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User getUserByUsernameAndPassword(String username, String password);
}
