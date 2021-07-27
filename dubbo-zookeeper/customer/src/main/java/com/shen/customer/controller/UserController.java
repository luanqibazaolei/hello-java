package com.shen.customer.controller;

import com.shen.common.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@ResponseBody
@RestController
public class UserController {

//    @Resource
    @Reference(version = "1.0.0")
    UserService userService;

    @GetMapping("/test")
    public String test(){

        return userService.findUser();
    }
}
