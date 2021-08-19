package com.example.factory.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserFactory {
    @Autowired
    private Map<String,User> map = new ConcurrentHashMap();

    public User getStrategy(String component) throws Exception{
        User user= map.get(component);
        if(user == null) {
            throw new RuntimeException("no user defined");
        }
        return user;
    }

}
