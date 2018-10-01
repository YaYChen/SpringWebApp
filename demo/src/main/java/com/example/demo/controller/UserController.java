package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    @RequestMapping("/users")
    public String users(){
        List<User> users = userMapper.selectAll();
        String usersJson = JSON.toJSONString(users);
        return usersJson;
    }
}
