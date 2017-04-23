package com.souvc.dao;

import java.util.List;

import com.souvc.entity.Dept;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MyBatisDeptDAO implements DeptDAO{
    
    private SqlSessionTemplate template;
    
    @Autowired
    public void setTemplate(SqlSessionTemplate template) {
        this.template = template;
    }

    @Override
    public List<Dept> findAll() {
        List<Dept> list = template.selectList("findAll");
        return list;
    }

}
