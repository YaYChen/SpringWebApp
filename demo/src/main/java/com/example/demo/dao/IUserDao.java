package com.example.demo.dao;

import com.example.demo.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    public List<UserEntity> selectAll();
}
