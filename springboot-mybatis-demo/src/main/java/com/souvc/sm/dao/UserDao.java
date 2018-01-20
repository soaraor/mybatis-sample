package com.souvc.sm.dao;

import com.souvc.sm.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User findUserById(Integer id);
}