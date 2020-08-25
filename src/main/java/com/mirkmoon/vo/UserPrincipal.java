package com.mirkmoon.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mirkmoon.components.common.Consts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * ClassName: UserPrincipal.java
 * Description: 自定义User
 * Author: liqihuang
 *
 * @createTime 2020年08月25日 10:42
 * Version: 1.0
 **/

@Data
//提供无参构造
@NoArgsConstructor
//提供全参构造
@AllArgsConstructor

public class UserPrincipal implements UserDetails {

    //主键
    private Long id;

    //用户名
    private String username;

    //密码
    @JsonIgnore
    private String password;

    //性别
    private String gander;

    //邮箱
    private String email;

    //手机
    private String phone;

    //头像
    private String headImg;

    //状态，启用-1，禁用-0
    private Integer status;

    /**
     * 生日
     */
    private Long birthday;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 用户角色列表
     */
    private List<String> roles;

    /**
     * 用户权限列表
     */
    private Collection<? extends GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Objects.equals(this.status, Consts.ENABLE);
    }
}
