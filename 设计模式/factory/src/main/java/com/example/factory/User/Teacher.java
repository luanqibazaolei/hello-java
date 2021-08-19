package com.example.factory.User;

import org.springframework.stereotype.Component;

@Component("teacher")
public class Teacher implements User{
    public String test() {
        return "Teacher Test!";
    }
}
