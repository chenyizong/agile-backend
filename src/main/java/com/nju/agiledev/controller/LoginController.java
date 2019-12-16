package com.nju.agiledev.controller;

import com.nju.agiledev.po.User;
import com.nju.agiledev.result.Result;
import com.nju.agiledev.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {

        User user = userService.getUser(requestUser.getUsername(), requestUser.getPassword());

        if (user == null) {
            return new Result(400);
        } else {
            return new Result(200);
        }

    }

}
