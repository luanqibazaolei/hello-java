package com.shen.provider.server.impl;

import com.shen.common.service.UserService;
import org.apache.dubbo.config.annotation.Service;



@Service(version = "1.0.0" )
public class UserServiceImpl implements UserService {

    @Override
    public String findUser() {
        System.out.println("服务者被获取到了");
        return "服务被获取到了";
    }
}
