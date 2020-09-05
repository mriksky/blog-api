package com.mirkmoon.config.security;

import com.mirkmoon.components.utils.ResponseUtil;
import com.mirkmoon.dto.Status;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @ClassName: SecurityHandlerConfig
 * @Description: Security 结果处理配置
 * @Author: liqihuang
 * @createTime 2020年09月05日 13:03
 * @Version: 1.0
 **/
@Configuration
public class SecurityHandlerConfig {
    /**
     * @description 
     * @param 
     * @updateTime 2020/9/5 21:39
     * @throws 
     * @return 
     **/
    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return (request, response, accessDeniedException) -> ResponseUtil.renderJson(response, Status.ACCESS_DENIED, null);
    }
}
