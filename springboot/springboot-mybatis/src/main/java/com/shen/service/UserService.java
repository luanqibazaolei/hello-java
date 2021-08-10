package com.shen.service;

import com.github.pagehelper.PageInfo;
import com.shen.User;

import java.util.List;

public interface UserService {
    PageInfo<User> getAllUser(int pageNo , int pageSize);
}
