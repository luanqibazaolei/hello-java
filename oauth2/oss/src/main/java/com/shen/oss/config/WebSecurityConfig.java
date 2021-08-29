package com.shen.oss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true , securedEnabled = true , jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        使用userDetailsService来创建用户 ，方便整合数据库 ， 将用户的账号密码保存在数据库
        auth.userDetailsService(userDetailsService);
//          自定义用户的方式
//                inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder.encode("123456")).roles("ADMIN")
//                .and()
//                .withUser("user").password(passwordEncoder.encode("123456")).roles("USER");
    }
}
