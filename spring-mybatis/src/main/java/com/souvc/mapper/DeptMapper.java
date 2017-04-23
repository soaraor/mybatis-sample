package com.souvc.mapper;


import com.souvc.annotation.MyBatisRepository;
import com.souvc.entity.Dept;

import java.util.List;

@MyBatisRepository
public interface DeptMapper {

    public List<Dept> findAll();

}
