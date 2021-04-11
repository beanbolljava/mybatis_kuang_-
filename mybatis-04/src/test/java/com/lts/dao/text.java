package com.lts.dao;

import com.lts.pojo.user;
import com.lts.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class text {
    //通过注解来查询全部用户
    @Test
    public void getUser(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        userMapper userMapper=sqlSession.getMapper(com.lts.dao.userMapper.class);
        List<user> userList=userMapper.getuser();

        for(user user:userList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    //通过注解来查询指定用户
    @Test
    public void getUserbyID(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        userMapper user=sqlSession.getMapper(com.lts.dao.userMapper.class);
        user users=user.getuserbyid(1,"爱新觉罗");
        System.out.println(users);
        sqlSession.close();
    }

    //插入指定数据
    @Test
    public void insertuser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        userMapper userMapper=sqlSession.getMapper(com.lts.dao.userMapper.class);
        int s=userMapper.insertuser(4,"王哥",new Date(),"男","山东");

        sqlSession.close();
    }

    //更新数据
    @Test
    public void updateuser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        userMapper userMapper=sqlSession.getMapper(com.lts.dao.userMapper.class);
        int s=userMapper.updateuser(new user(4,"小王",new Date(),"女","青岛"));
        sqlSession.close();
    }
    //删除数据
    @Test
    public void deleteuser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        userMapper userMapper=sqlSession.getMapper(com.lts.dao.userMapper.class);
        int s=userMapper.deleteuser(4);
        sqlSession.close();
    }
}
