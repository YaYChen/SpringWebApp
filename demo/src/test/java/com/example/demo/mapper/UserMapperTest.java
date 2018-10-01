package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectAll() throws Exception{
        List<User> users = userMapper.selectAll();
        for(User u : users){
            System.out.print("UserName: "+u.getUsername());
        }
    }
}