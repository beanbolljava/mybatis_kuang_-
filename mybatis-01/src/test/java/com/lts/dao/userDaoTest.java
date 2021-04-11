package com.lts.dao;

import com.lts.pojo.user;
import com.lts.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class userDaoTest {
    @Test
    public void text() {
        //获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //执行sql
            userDao userDao = sqlSession.getMapper(userDao.class);
            List<user> userList = userDao.getuserList();
            for (user user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlsession
            sqlSession.close();
        }


    }

    @Test
    public void textbyid() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            userDao userDao = sqlSession.getMapper(userDao.class);
            user user = userDao.getuserbyid(41);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void textbylike(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        userDao userDao=sqlSession.getMapper(com.lts.dao.userDao.class);
        List<user> userList=userDao.getuserbylike("%李%");
        for(user user:userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void textadd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userDao userDao = sqlSession.getMapper(userDao.class);
        int s = userDao.adduser(new user(1, "康熙", new Date(), "男", "故宫"));
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void textmapadd(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        userDao userDao=sqlSession.getMapper(userDao.class);
    //map对象所对应的xml文件不写全也可以
        //数据表中的字段过多可以用map来写，只用写用到的字段
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("userid",1);
        map.put("userusername","爱新觉罗");
        map.put("userbirthday",new Date());
        map.put("usersex","男");
        map.put("useraddress","故宫");

        int s=userDao.adduserbymap(map);

        sqlSession.commit();


        sqlSession.close();
    }

    @Test
    public void textupdate() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userDao userDao = sqlSession.getMapper(userDao.class);
        int s = userDao.updatede(new user(1, "顺治", new Date(), "男", "故宫"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void textdeletd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userDao userDao = sqlSession.getMapper(userDao.class);
        int s = userDao.deletet(1);
        sqlSession.commit();
        sqlSession.close();
    }
}
