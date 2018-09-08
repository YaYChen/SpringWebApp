package com.example.demo.dao;

import com.example.demo.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<UserEntity> searchAll();
}
