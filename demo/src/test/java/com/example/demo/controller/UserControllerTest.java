package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.IUserDao;
import com.example.demo.model.UserEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@AutoConfigureMockMvc
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserControllerTest {

    @Autowired
    private IUserDao dao;
    @Autowired
    private MockMvc mvc;


    @Test
    public void users() throws Exception{
        List<UserEntity> users = dao.selectAll();
        mvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.content().string(JSON.toJSONString(users)));
    }
}