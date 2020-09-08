package com.mirkmoon.service;

import com.mirkmoon.mapper.PermissionMapper;
import com.mirkmoon.mapper.RoleMapper;
import com.mirkmoon.mapper.UserMapper;
import com.mirkmoon.pojo.Permission;
import com.mirkmoon.pojo.Role;
import com.mirkmoon.pojo.User;
import com.mirkmoon.vo.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * @param  usernameOrEmailOrPhone
     * @updateTime 2020/9/5 14:21
     * @throws
     * @return 
     **/
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmailOrPhone) throws UsernameNotFoundException {
        User user = userMapper.queryByUsernameOrEmailOrPhone(usernameOrEmailOrPhone, usernameOrEmailOrPhone, usernameOrEmailOrPhone)
                .orElseThrow((() -> new UsernameNotFoundException("未找到用户信息" + usernameOrEmailOrPhone)));
        List<Role> roles = roleMapper.queryByUserId(user.getId());
        List<Long> roleIds = roles.stream()
                .map(Role::getId)
                .collect(Collectors.toList());
        List<Permission> permissions = permissionMapper.selectByRoleIdList(roleIds);
        return UserPrincipal.create(user,roles,permissions);
    }
}
