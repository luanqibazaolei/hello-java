package com.example.factory.User;

import org.springframework.stereotype.Component;

@Component("student")
public class Student implements User{
    public String test() {
        return "Student Test!";
    }
}
