package com.nju.agiledev.dao;

import com.nju.agiledev.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    /**
     * 通过用户名查找用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 通过用户名和密码查找用户信息
     * @param username
     * @param password
     * @return
     */
    User getUserByUsernameAndPassword(String username, String password);
}
