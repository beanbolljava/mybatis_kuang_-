package com.lts.dao;

import com.lts.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //通过配置xml文件来获取学生及其老师的值
    public List<Student> getstudent();

    public List<Student> getstudent2();


}
