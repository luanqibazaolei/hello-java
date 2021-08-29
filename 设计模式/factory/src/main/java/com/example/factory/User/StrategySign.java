package com.example.factory.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StrategySign {

    private User user;

    @Autowired
    private Map<String, User> map = new ConcurrentHashMap();

    public StrategySign() {
    }

    public StrategySign(User user) {
        this.user = user;
    }

    public StrategySign(String type) throws Exception{
        this.user= map.get(type);

    }
    public void getStrategy(String type)throws Exception{
        this.user= map.get(type);

    }

    public String test() {
        return this.user.test();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }
}
