package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zmj
 * @date 2020/7/29 9:13
 * @Description 配置类
 */
@Configuration
public class ApplicationContextConfig {
    /**
     * 创建RestTemplate
     * @return new RestTemplate();
     * @LoadBalanced 开启负载均衡
     */
    @Bean("RestTemplate")
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
