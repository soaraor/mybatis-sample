package com.souvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.souvc.dao.EmpDAO;
import com.souvc.entity.Condition;
import com.souvc.entity.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class TestEmpDAO {

    /**
     * 测试查询全部数据
     *
     * @throws IOException
     */
    @Test
    public void testFindAll() throws IOException {
        String conf = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        EmpDAO mapper = ac.getBean("empDAO", EmpDAO.class);
        List<Emp> list = mapper.findAll();
        for (Emp emp : list) {
            System.out.println(emp.getEmpno() + " " + emp.getEname());
        }
    }


    /**
     * 根据部门查询员工
     */
    @Test
    public void testFindByDept() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpDAO dao = ctx.getBean(EmpDAO.class);
        Condition cond = new Condition();
        cond.setDeptno(10);
        List<Emp> list = dao.findByDept(cond);
        for (Emp e : list) {
            System.out.println(
                    e.getEmpno() + " " +
                            e.getEname() + " " +
                            e.getJob()
            );
        }
    }


    /**
     * 查询大于当前收入的员工
     */
    @Test
    public void testFindBySalary() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpDAO dao = ctx.getBean(EmpDAO.class);
        Condition cond = new Condition();
        cond.setSalary(4000.0);
        List<Emp> list = dao.findBySalary(cond);
        for (Emp e : list) {
            System.out.println(
                    e.getEmpno() + " " +
                            e.getEname() + " " +
                            e.getJob()
            );
            }
        }

    /**
     * 查询当前部门下,大于当前收入的员工
     */
    @Test
    public void testFindByDeptAndSalary() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpDAO dao = ctx.getBean(EmpDAO.class);
        Condition cond = new Condition();
        cond.setDeptno(20);
        cond.setSalary(2000.0);
        List<Emp> list = dao.findByDeptAndSalary(cond);
        for(Emp e : list) {
            System.out.println(
                    e.getEmpno() + " " +
                            e.getEname() + " " +
                            e.getJob()
            );
        }
    }



    /**
     * 更新员工
     */
    @Test
    public void testUpdate() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpDAO dao = ctx.getBean(EmpDAO.class);
        Emp e = new Emp();
        e.setEmpno(14);
        e.setEname("Leo");
        dao.update(e);
    }




    /**
     * 查询当前部门下,大于当前收入的员工
     */
    @Test
    public void testFindByDeptAndSalary2() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpDAO dao = ctx.getBean(EmpDAO.class);
        Condition cond = new Condition();
        cond.setDeptno(20);
        cond.setSalary(2000.0);
        List<Emp> list = dao.findByDeptAndSalary2(cond);
        for(Emp e : list) {
            System.out.println(
                    e.getEmpno() + " " +
                            e.getEname() + " " +
                            e.getJob()
            );
        }
    }

    /**
     * 更新员工
     */
    @Test
    public void testUpdate2() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpDAO dao = ctx.getBean(EmpDAO.class);
        Emp e = new Emp();
        e.setEmpno(14);
        e.setEname("Lee2");
        dao.update2(e);
    }




    /**
     * 根据员工ID查询员工
     */
    @Test
    public void testFindByIds() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpDAO dao = ctx.getBean(EmpDAO.class);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(3);
        ids.add(7);
        ids.add(8);
        Condition cond = new Condition();
        cond.setEmpnos(ids);
        List<Emp> list = dao.findByIds(cond);
        for(Emp e : list) {
            System.out.println(
                    e.getEmpno() + " " +
                            e.getEname() + " " +
                            e.getJob()
            );
        }
    }



}


