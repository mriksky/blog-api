package com.mirkmoon.components.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName JwtConfig
 * @Description JWT 配置
 * @Author liqihuang
 * @Date 2020/8/21 12:41
 * @Version v1.0
 **/
@Data
//获取jwt的配置注解
@ConfigurationProperties(prefix = "jwt.config")
public class JwtConfig {
    /**
     * jwt 加密 key，默认值：
     **/
    private String key = "I-LIKE-CODING";

    /**
     * jwt 过期时间，默认值：600000 {@code 10 分钟}.
     */
    private Long ttl = 600000L;

    /**
     * 开启 记住我 之后 jwt 过期时间，默认值 604800000 {@code 7 天}
     */
    private Long remember = 604800000L;
}
