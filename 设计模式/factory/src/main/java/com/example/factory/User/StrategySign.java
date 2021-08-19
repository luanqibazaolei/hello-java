package com.example.factory.User;

import org.springframework.stereotype.Service;

@Service
public class StrategySign {

    private User user;

    public StrategySign() {
    }

    public StrategySign(User user) {
        this.user = user;
    }

    public StrategySign(String type) {
        if (type.equals("student")) {
            this.user = new Student();
        } else if (type.equals("teacher")) {
            this.user = new Teacher();
        }

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
}
