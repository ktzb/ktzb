package com.example.ktzb.dao;

import com.example.ktzb.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public User getNameById(User user);

}



