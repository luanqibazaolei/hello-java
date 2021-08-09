package com.shen.rabbit.controller;

import com.shen.rabbit.prodecer.Prodecer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/rest")
public class RestfulController {

    @Autowired
    Prodecer prodecer ;
    @GetMapping("/message")
    public void message(){
        prodecer.send();
    }
}