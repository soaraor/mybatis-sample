package com.souvc.dao;


import com.souvc.annotation.MyBatisRepository;
import com.souvc.entity.Condition;
import com.souvc.entity.Emp;

import java.util.List;

@MyBatisRepository
public interface EmpDAO {

    List<Emp> findAll();

    List<Emp> findByDept(Condition cond);

    List<Emp> findBySalary(Condition cond);

    List<Emp> findByDeptAndSalary(Condition cond);

    void update(Emp emp);

    List<Emp> findByDeptAndSalary2(Condition cond);

    void update2(Emp emp);

    List<Emp> findByIds(Condition cond);

}
