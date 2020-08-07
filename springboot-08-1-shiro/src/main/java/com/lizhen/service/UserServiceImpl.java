package com.lizhen.service;


import com.lizhen.mapper.UserMapper;
import com.lizhen.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User querryUserByName(String name) {
        return userMapper.querryUserByName(name);
    }
}
