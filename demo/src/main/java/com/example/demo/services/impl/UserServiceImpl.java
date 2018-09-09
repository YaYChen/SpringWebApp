package com.example.demo.services.impl;

import com.example.demo.dao.IUserDao;
import com.example.demo.model.UserEntity;
import com.example.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("IUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao dao;

    public List<UserEntity> selectAll() {
        return this.dao.selectAll();
    }
}
