package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.UserDao;
import com.example.demo.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    UserDao userDao;

    @RequestMapping("/users")
    public String users(){
        List<UserEntity> users = userDao.searchAll();
        String usersJson = JSON.toJSONString(users);
        return usersJson;
    }
}
