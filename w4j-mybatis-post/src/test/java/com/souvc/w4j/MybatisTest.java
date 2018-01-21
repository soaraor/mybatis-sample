package com.souvc.w4j;

import com.souvc.w4j.dao.PostsMapper;
import com.souvc.w4j.entity.Posts;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

/**
 * 测试类
 */
public class MybatisTest {

    SqlSession session=null;
    /**
     * 获取SqlSession对象案例
     */
    @Before
    public void getSqlSession() throws IOException{
        String conf = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(conf);
        //创建SessionFactory对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        //创建Session
        session = sf.openSession();
        System.out.println(session);
    }
    //关闭Session
    @After
    public  void  close(){
        session.close();
    }

    @Test
    public void test(){
        Posts posts=new Posts();
        posts.setId(null);
        posts.setPostAuthor(1L);
        posts.setPostTitle("博客标题");
        posts.setPostContent("博客内容");
        posts.setPostDate(new Date());
        posts.setPostStatus("publish");
        PostsMapper mapper = session.getMapper(PostsMapper.class);
        mapper.insertSelective(posts);

        session.commit();
    }

    @Test
    public void test2(){
        Posts posts=new Posts();
        posts.setId(11L);
        posts.setPostAuthor(1L);
        posts.setPostTitle("博客标题");
        posts.setPostContent("博客内容-修改过的内容！");
        posts.setPostDate(new Date());
        posts.setPostStatus("publish");
        PostsMapper mapper = session.getMapper(PostsMapper.class);
        mapper.updateByPrimaryKey(posts);

        session.commit();
    }

    @Test
    public void test3(){
        Posts posts=new Posts();
        posts.setId(11L);
        posts.setPostAuthor(1L);
        posts.setPostTitle("博客标题");
        posts.setPostContent("博客内容-修改过的内容--！");
        posts.setPostDate(new Date());
        posts.setPostStatus("publish");
        PostsMapper mapper = session.getMapper(PostsMapper.class);
        mapper.updateByPrimaryKeyWithBLOBs(posts);

        session.commit();
    }

}
