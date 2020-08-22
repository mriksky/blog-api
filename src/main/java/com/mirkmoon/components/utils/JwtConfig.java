package com.mirkmoon.components.utils;

/**
 * @ClassName JwtConfig
 * @Description JWT 配置
 * @Author liqihuang
 * @Date 2020/8/21 12:41
 * @Version v1.0
 **/
public class JwtConfig {
    /**
     * jwt 加密 key，默认值：xkcoding.
     **/
    private static final String SECRET_KEY = "I-LIKE-CODING";

    /**
     * jwt 过期时间，默认值：600000 {@code 10 分钟}.
     */
    private Long ttl = 600000L;

    /**
     * 开启 记住我 之后 jwt 过期时间，默认值 604800000 {@code 7 天}
     */
    private Long remember = 604800000L;
}
