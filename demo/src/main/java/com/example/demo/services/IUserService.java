package com.example.demo.services;

import com.example.demo.model.UserEntity;

import java.util.List;

public interface IUserService {
    public List<UserEntity> selectAll();
}
