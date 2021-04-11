package com.lts.dao;

import com.lts.pojo.Blog;
import com.lts.utlis.IDutlis;
import com.lts.utlis.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class Mytest {
    @Test
    public void test(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
        Blog blog=new Blog();

        blog.setId(IDutlis.getId());
        blog.setTitle("java从入门到入土");
        blog.setAuthor("lts");
        blog.setCreate_Date(new Date());
        blog.setView(444);

        blogMapper.addbook(blog);

        blog.setId(IDutlis.getId());
        blog.setTitle("mybatis从入门到入土");
        blog.setAuthor("lts");
        blog.setCreate_Date(new Date());
        blog.setView(555);

        blogMapper.addbook(blog);

        blog.setId(IDutlis.getId());
        blog.setTitle("hibernate从入门到入土");
        blog.setAuthor("lts");
        blog.setCreate_Date(new Date());
        blog.setView(555);

        blogMapper.addbook(blog);

        sqlSession.close();

    }

    @Test
    public void testsql(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
        Map map=new HashMap();
        map.put("title","java从入门到入土");
        map.put("author","lts");
        List<Blog> listBlog=blogMapper.selectsql(map);
        for (Blog blog : listBlog) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void testsql1(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
        Map map=new HashMap();
//        map.put("title","java从入门到入土");
//        map.put("author","lts");
        map.put("view",555);
        List<Blog> listBlog=blogMapper.querySql(map);
        for (Blog blog : listBlog) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void testupdate(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
        Map map=new HashMap();
        map.put("id","6e2f0b8ad698413e89df5854934022a7");
        map.put("title","Spring从入门到入土");
        map.put("author","ltss");
        int s=blogMapper.updateblog(map);
        sqlSession.close();
    }

    @Test
    public void testbydoreach(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);

        Map map=new HashMap();
        ArrayList<Integer> ids=new ArrayList<Integer>();

        ids.add(1);
        ids.add(2);
        map.put("ids",ids);

        List<Blog> listBlog=blogMapper.selectByforeach(map);

        sqlSession.close();
    }
}
