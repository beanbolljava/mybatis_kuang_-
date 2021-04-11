package com.lts.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

//不建议这样写，对新手不友好
@Alias("hello")
@Data//无参构造，有参构造，get,set ,toString,HashCode,equals
@AllArgsConstructor//有参构造器
@NoArgsConstructor//无参构造器
public class user {
    private int id;
    private String name;
    private Date birthday;
    private String sex;
    private String address;
}
