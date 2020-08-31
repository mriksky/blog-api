package com.mirkmoon.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName CustomConfig
 * @Description TODO
 * @Author liqihuang
 * @Date 2020/8/31 18:35
 * @Version v1.0
 **/

@ConfigurationProperties(prefix = "custom.config")
@Data
public class CustomConfig {
    private IgnoreConfig ignores;
}
