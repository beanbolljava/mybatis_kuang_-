package com.lts.dao;

import com.lts.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //动态sql
    int addbook(Blog blog);

    List<Blog> selectsql(Map map);

    //查询语句choose when otherwise
    List<Blog> querySql(Map map);

    //update博客
    int updateblog(Map map);

    //用foreach来查询id为1，2，3的数据
    List<Blog> selectByforeach(Map map);
}
