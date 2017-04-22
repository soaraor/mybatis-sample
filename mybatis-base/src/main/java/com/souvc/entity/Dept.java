package com.souvc.entity;

/**
 * 部门类
 */
public class Dept{

    //部门号
    private Integer deptno;
    //部门名字
    private String dname;
    //部门
    private String loc;

    public Integer getDeptno() {
        return deptno; 
    }
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }
    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }
    public String getLoc() {
        return loc;
    }
    public void setLoc(String loc) {
        this.loc = loc;
    }
}
