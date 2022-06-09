package com.hust.service.impl;

import com.hust.dao.UserMapper;
import com.hust.entity.User;
import com.hust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(int id) {
        return userMapper.selectById(id);
    }
}
