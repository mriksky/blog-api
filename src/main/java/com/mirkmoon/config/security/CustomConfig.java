package com.mirkmoon.config.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName CustomConfig
 * @Description  自定义url配置类
 * @Author liqihuang
 * @Date 2020/8/31 18:35
 * @Version v1.0
 **/

@ConfigurationProperties(prefix = "custom.config")
@Data
public class CustomConfig {
    //不需要拦截的地址
    private IgnoreConfig ignores;
}
