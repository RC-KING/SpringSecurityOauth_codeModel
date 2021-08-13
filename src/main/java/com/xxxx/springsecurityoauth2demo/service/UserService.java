package com.xxxx.springsecurityoauth2demo.service;

import com.xxxx.springsecurityoauth2demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 这里的密码应该是数据库查询到的,这里方便演示,没有去数据库查
        String password = passwordEncoder.encode("123456");
        // 这里的User类是自定义的,要实现UserDetails类
        return new User("admin",password, AuthorityUtils
                .commaSeparatedStringToAuthorityList("admin"));
    }
}
