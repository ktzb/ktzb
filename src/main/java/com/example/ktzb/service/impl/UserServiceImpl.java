package com.example.ktzb.service.impl;

import com.example.ktzb.dao.UserDao;
import com.example.ktzb.entity.User;
import com.example.ktzb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User getNameById(User user) {
        return userDao.getNameById(user);
    }

}
