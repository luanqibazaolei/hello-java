package com.shen.controller;

import com.github.pagehelper.PageInfo;
import com.shen.User;
import com.shen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public PageInfo<User> list(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                               @RequestParam(value="pageSize",defaultValue="10")int pageSize) {
        PageInfo<User> page = userService.getAllUser(pageNo,pageSize);
        return  page;
    }
}
