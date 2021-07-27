package com.example.security.config;

import com.example.security.filter.TokenAuthenticationFilter;
import com.example.security.filter.TokenLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                // 跨域预检请求
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // home页面
                .antMatchers("/home").permitAll()
                // 登录URL
                .antMatchers("/login").permitAll()

                // 用户权限

                // 只有ADMIN 用户可以访问
                .antMatchers(("/admin")).hasAnyRole("ADMIN")
                .antMatchers("/admin/").hasAnyRole("ADMIN")
                // ADMIN 用户 和 USER用户可以访问
                .antMatchers("/user/").access("hasRole('ADMIN') or hasRole('USER')")


                // swagger
                .antMatchers("/swagger**/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                // 其他所有请求需要身份认证
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").and()
//                .addFilter(new TokenAuthenticationFilter(authenticationManager()))
//                .addFilter(new TokenLoginFilter(authenticationManager()))

                .logout().permitAll();
    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
//                自定义用户构筑器
                .inMemoryAuthentication()
                .withUser("user").password("user").roles("USER").and()
                .withUser("admin").password("admin").roles("ADMIN").and()
//                新版本 必须添加 passwordEncoder 否则报错 ：There is no PasswordEncoder mapped for the id "null"
//
                .passwordEncoder(new PasswordEncoder() {
                    @Override
                    public String encode(CharSequence charSequence) {
                        return charSequence.toString();
                    }

                    @Override
                    public boolean matches(CharSequence charSequence, String s) {
                        return s.equals(charSequence.toString());
                    }
                });
    }
}
