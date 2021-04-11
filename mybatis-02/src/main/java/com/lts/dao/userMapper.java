package com.lts.dao;

import com.lts.pojo.user;

import java.util.List;
import java.util.Map;

public interface userMapper {
    //查询所有的人
    List<user> getuserList();
    //通过id来查找数据
    user getuserbyid(int id);
    //向数据库中插入数据
    int adduser(user u);
    //更新数据库的数据
    int updatede(user u);
    //删除数据库中的数据
    int deletet(int u);
}
