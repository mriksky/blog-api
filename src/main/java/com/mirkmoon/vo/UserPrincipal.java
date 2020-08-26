package com.mirkmoon.vo;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mirkmoon.components.common.Consts;
import com.mirkmoon.pojo.Permission;
import com.mirkmoon.pojo.Role;
import com.mirkmoon.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * ClassName: UserPrincipal.java
 * Description: 自定义User
 * Author: liqihuang
 *
 * @createTime 2020年08月25日 10:42
 * Version: 1.0
 **/

@Data
@NoArgsConstructor
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

    //生日
    private Long birthday;

    //创建时间
    private Long createTime;

    //更新时间
    private Long updateTime;

    //用户角色列表
    private List<String> roles;

    //用户权限列表
    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user, List<Role> roles, List<Permission> permissions){
        List<String> roleNames = roles.stream()
                .map(Role::getRolename)
                .collect(Collectors.toList());

        List<GrantedAuthority> authorities = permissions.stream()
                .filter(permission -> StrUtil.isNotBlank(permission.getPermission()))
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        return new UserPrincipal();
    }


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
