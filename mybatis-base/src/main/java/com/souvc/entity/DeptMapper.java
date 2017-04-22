package com.souvc.entity;


import java.util.List;

public interface DeptMapper {
    //增加部门
    public void addDept(Dept dept);

    //更新部门信息
    public void updateDept(Dept dept);

    //根据Id删除
    public void deleteById(int id);

    //根据ID查询部门
    public Dept findById(int id);

    //查询全部
    public List<Dept> findAll();


}
