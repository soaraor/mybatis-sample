package com.souvc;

import com.souvc.entity.Dept;
import com.souvc.entity.Dept1;
import com.souvc.entity.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

/**
 * 测试类
 */
public class MybatisTest {

    /**
     * 获取SqlSession对象案例
     * @throws IOException
     */
    @Test
    public void testSqlSession() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();
        System.out.println(session);
        //关闭Session
        session.close();
    }

    /**
     * 测试插入方法
     * @throws IOException
     */
    @Test
    public void testInsert() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =  new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        //调用addDept操作
        Dept dept = new Dept();
        dept.setDeptno(66);
        dept.setDname("testing");
        dept.setLoc("beijing");
        session.insert("addDept",dept);
        System.out.println("插入成功");

        session.commit();
        //关闭
        session.close();
    }


    /**
     * 测试更新方法
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =  Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =   new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        //调用findById操作
        Dept dept = (Dept) session.selectOne("findById",66);
        dept.setDname("开发部");
        dept.setLoc("北京");
        //调用updateDept操作
        session.update("updateDept",dept);
        System.out.println("更新成功！");

        session.commit();
        //关闭
        session.close();
    }

    /**
     * 测试删除方法
     * @throws IOException
     */
    @Test
    public void testDelete() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        //调用deleteById操作
        session.delete("deleteById",66);
        System.out.println("删除成功！");

        session.commit();
        //关闭
        session.close();
    }


    /**
     * 测试根据Id查询方法
     * @throws IOException
     */
    @Test
    public void testFindById() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        // 创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        // 创建Session
        SqlSession session = sf.openSession();

        // 调用findById方法
        Dept dept = (Dept) session.selectOne("findById", 10);
        System.out.println(dept.getDeptno() + " ，" + dept.getDname() +
                " ， " + dept.getLoc());

        // 关闭
        session.close();
    }


    /**
     * 测试查询全部数据
     * @throws IOException
     */
    @Test
    public void testFindAll() throws IOException {
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        // 创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        // 创建Session
        SqlSession session = sf.openSession();
        // 调用findAll方法
        List<Dept> list = session.selectList("findAll");
        for (Dept dept : list) {
            System.out.println(dept.getDeptno() + " " + dept.getDname() + " "
                    + dept.getLoc());
        }
        session.close();
    }


    /**
     * 测试分页
     * @throws IOException
     */
    @Test
    public void testFindPage() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader =  Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        int offset = 2;//起点,从2开始
        int limit = 2;//查几条
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<Dept> list =  session.selectList("findAll",null,rowBounds);
        for(Dept dept : list){
            System.out.println(dept.getDeptno()+" "
                    +dept.getDname()+" "
                    +dept.getLoc());
        }
        session.close();
    }


    /**
     * 返回部门对象
     * @throws IOException
     */
    @Test
    public void findDept() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        Map map = (Map)session.selectOne("findDept",10);
        System.out.println(map.get("DEPTNO") +" "+map.get("DNAME"));

        session.close();
    }

    /**
     * 使用Mapper对Dept表操作案例
     * @throws IOException
     */
    @Test
    public void testDeptMapper() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =  new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        DeptMapper mapper =  session.getMapper(DeptMapper.class);
        //调用findAll方法
        List<Dept> list = mapper.findAll();
        for(Dept dept : list){
            System.out.println(dept.getDeptno()+" "
                    +dept.getDname()+" "
                    +dept.getLoc());
        }

        session.close();
    }


    /**
     * 测试自定义测试返回
     * @throws IOException
     */
    @Test
    public void testResultMap() throws IOException{
        String conf = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb =  new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        SqlSession session = sf.openSession();

        DeptMapper mapper = session.getMapper(DeptMapper.class);
        //调用findAll方法
        List<Dept1> list = mapper.findAll1();
        for(Dept1 dept : list){
            System.out.println(dept.getNo()+" "
                    +dept.getName()+" "
                    +dept.getLoc());
        }
        session.close();
    }


}
