package com.shen.service;

import com.github.pagehelper.PageInfo;
import com.shen.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public PageInfo<User> getAllUser(int pageNo, int pageSize) {
        return null;
    }
}
