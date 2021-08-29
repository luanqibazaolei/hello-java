package com.example.factory.config;

import com.example.factory.User.StrategySign;
import com.example.factory.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class UserConfiguration {



    @Bean( name = "studentStrategySign")
    StrategySign strategySign() throws Exception {
        return new StrategySign("student");
    }
}
