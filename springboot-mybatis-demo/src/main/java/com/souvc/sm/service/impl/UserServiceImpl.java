package com.souvc.sm.service.impl;

import com.souvc.sm.entity.User;
import com.souvc.sm.dao.UserDao;
import com.souvc.sm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public User findUserById(Integer id){
        return userDao.findUserById(id);
    }
}