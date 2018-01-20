package com.souvc.sm.controller;

import com.souvc.sm.service.impl.UserServiceImpl;
import com.souvc.sm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/")
    public String hello() throws Exception {
        return "hello world";
    }

    @RequestMapping("/findUserById")
    public User findUserById(@RequestParam(value="id") Integer id){
        User user = userServiceImpl.findUserById(id);
        return user;
    }
}