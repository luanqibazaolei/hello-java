package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
//    @GetMapping("/login")
//    public ModelAndView hello() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("hello");
//        return modelAndView;
//    }
//    @GetMapping("/logout")
//    public ModelAndView logout() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }
//    @RequestMapping("/userlogin")
//    public String hello(String name , String passWord){
//        return "hello";
//    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/user")
    public String user(){
        return "/user";
    }

}
