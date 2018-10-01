package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user_table")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",  column = "name"),
            @Result(property = "password", column = "password")
    })
    List<User> selectAll(); 
}
