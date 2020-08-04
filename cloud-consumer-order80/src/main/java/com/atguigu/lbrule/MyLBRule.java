package com.atguigu.lbrule;

import com.atguigu.springcloud.config.MyRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zmj
 * @date 2020/7/30 8:43
 * @Description 自定义loadbalancer规则
 */
@Configuration
public class MyLBRule {

    /**
     * 启用随机均衡
     * @return
     */
    @Bean
    public IRule getIRule() {
        return new MyRule();
    }

}
