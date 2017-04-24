package com.souvc.dao;


import com.souvc.annotation.MyBatisRepository;
import com.souvc.entity.Emp;

import java.util.List;

@MyBatisRepository
public interface EmpDAO {

    public List<Emp> findAll();

}
