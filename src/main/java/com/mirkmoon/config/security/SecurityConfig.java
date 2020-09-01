package com.mirkmoon.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @ClassName SecurityConfig
 * @Description SecurityConfig安全设置
 * @Author liqihuang
 * @Date 2020/8/31 18:23
 * @Version v1.0
 **/
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(CustomConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }


    /**
     * @description 全局请求忽略规则配置
     * @param web
     * @return
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
    /**
     * @description 全局请求忽略规则配置
     * @param http
     * @return
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.cors()
       // 关闭 CSRF
       .and().csrf().disable()
       // 登录行为由自己实现，参考 AuthController#login
       .formLogin().disable()
       .httpBasic().disable()
        //认证请求
       .authorizeRequests()
       .anyRequest()
       .authenticated()
        //RBAC 动态 url 认证
       //.anyRequest()
       //.access("")
       // 登出行为由自己实现，参考 AuthController#logout
       .and().logout().disable()
       // Session 管理
       .sessionManagement()
       // 因为使用了JWT，所以这里不管理Session
       .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
