package com.mirkmoon.control;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * ClassName: LoginRequest.java
 * Description: 登录请求参数
 * Author: liqihuang
 * @createTime 2020年08月19日 23:39
 * Version: 1.0
 **/
@Data
public class LoginRequest {
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 记住我
     */
    private Boolean rememberMe = false;
}
