package com.shen.oss.config;

import com.shen.oss.entity.TbPermission;
import com.shen.oss.entity.TbUser;
import com.shen.oss.service.TbPermissionService;
import com.shen.oss.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    TbUserService userService;

    @Autowired
    TbPermissionService permissionService;

    /**
     * 查询数据库用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser tbUser = userService.getUserByUserName(username);
        if (tbUser == null){
            throw new UsernameNotFoundException("username: "+username + "is not exist!");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        List<TbPermission> permissions = permissionService.getByUserId(tbUser.getId());
//        遍历权限并添加
        permissions.forEach(tbPermission -> {
            authorities.add(new SimpleGrantedAuthority(tbPermission.getEname()));
        });



        return new User(tbUser.getUsername(), tbUser.getPassword(), authorities);
    }


}
