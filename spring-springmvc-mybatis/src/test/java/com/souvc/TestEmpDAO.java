package com.souvc;

import java.io.IOException;
import java.util.List;


import com.souvc.dao.EmpDAO;
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
     * @throws IOException
     */
    @Test
    public void testFindAll() throws IOException{
        String conf = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        EmpDAO mapper = ac.getBean("empDAO",EmpDAO.class);
        List<Emp> list = mapper.findAll();
        for(Emp emp : list){
            System.out.println(emp.getEmpno()+" "+emp.getEname());
        }
    }

}
