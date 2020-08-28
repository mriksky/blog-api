package com.mirkmoon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName JwtResponse
 * @Description 传递token的类型,JWT响应返回
 * @Author liqihuang
 * @Date 2020/8/28 18:22
 * @Version v1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    public String token;

    public String tokenType;

    public JwtResponse(String token){
        this.token=token;
    }
}
