package com.lts.dao;

import com.lts.pojo.user;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface userMapper {
    @Select("select * from user")
    List<user> getuser();

    @Select("select * from user where id=#{id} and username=#{username}")
    user getuserbyid(@Param("id") int id,@Param("username") String username);

    @Insert("insert into user(id,username,birthday,sex,address) value(#{id},#{username},#{birthday},#{sex},#{address})")
    int insertuser(@Param("id") int id, @Param("username") String username, @Param("birthday") Date birthday, @Param("sex") String sex, @Param("address") String address);

    @Update("update user set username=#{name},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    int updateuser(user u);

    @Delete("delete from user where id=#{id}")
    int deleteuser(@Param("id") int id);
}
