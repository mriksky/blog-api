package com.mirkmoon.config.auth;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: DynamicPermissionAuthConfig
 * @Description: 动态路由认证
 * @Author: liqihuang
 * @createTime 2020年09月05日 22:10
 * @Version: 1.0
 **/
//@Component
public class DynamicPermissionAuthConfig {

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        return true;
    }
    }
