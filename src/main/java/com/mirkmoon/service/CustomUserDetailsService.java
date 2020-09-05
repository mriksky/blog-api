package com.mirkmoon.service;

import com.mirkmoon.mapper.PermissionMapper;
import com.mirkmoon.mapper.RoleMapper;
import com.mirkmoon.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName: CustomUserDetailsService
 * @Description: 自定义UserDetails查询
 * @Author: liqihuang
 * @createTime 2020年09月05日 14:18
 * @Version: 1.0
 **/
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;
    /**
     * @description 
     * @param  username
     * @updateTime 2020/9/5 14:21
     * @throws
     * @return 
     **/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return null;
    }
}
