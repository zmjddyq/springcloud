package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zmj
 * @date 2020/8/2 9:14
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacosMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacosMain9001.class, args);
    }
}
