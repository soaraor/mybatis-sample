package com.souvc;

import java.io.IOException;
import java.util.List;


import com.souvc.dao.DeptDAO;
import com.souvc.entity.Dept;
import com.souvc.mapper.DeptMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class TestDeptMapper {

    /**
     * 通过spring的SqlSessionFactoryBean和MapperFactoryBean实现对Dept表查询操作案例
     * @throws IOException
     */
    @Test
    public void testFindAll() throws IOException {
        String conf = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        DeptMapper mapper = ac.getBean("deptMapper", DeptMapper.class);
        List<Dept> list = mapper.findAll();
        for (Dept dept : list) {
            System.out.println(dept.getDeptno() + " " + dept.getDname());
        }
    }


    /**
     * 通过 MapperScannerConfigurer实现对Dept表查询操作案例
     * @throws IOException
     */
    @Test
    public void testScanFindAll() throws IOException {
        String conf = "applicationContext-scan.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        DeptMapper mapper = ac.getBean("deptMapper", DeptMapper.class);
        List<Dept> list = mapper.findAll();
        for (Dept dept : list) {
            System.out.println(dept.getDeptno() + " " + dept.getDname());
        }
    }


    /**
     * 通过注解实现MapperScannerConfigurer对Dept表查询操作案例
     * @throws IOException
     */
    @Test
    public void testScanAnnotationFindAll() throws IOException {
        String conf = "applicationContext-scan-annotation.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        DeptMapper mapper = ac.getBean("deptMapper", DeptMapper.class);
        List<Dept> list = mapper.findAll();
        for (Dept dept : list) {
            System.out.println(dept.getDeptno() + " " + dept.getDname());
        }
    }


    /**
     * 通过SqlSessionTemplate实现对Dept表的Map类型查询操作案例
     * @throws IOException
     */
    @Test
    public void testTemplateFindAll() throws IOException {
        String conf = "applicationContext-template.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        DeptDAO dao = ac.getBean("myBatisDeptDAO", DeptDAO.class);
        List<Dept> list = dao.findAll();
        for (Dept dept : list) {
            System.out.println(dept.getDeptno() + " " + dept.getDname());
        }
    }


}
