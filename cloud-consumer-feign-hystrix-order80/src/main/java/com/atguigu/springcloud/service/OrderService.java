package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zmj
 * @date 2020/7/30 15:51
 * @Description
 */
@Component
@FeignClient(value = "cloud-payment-hystrix-com.atguigu.springcloud.service",fallback = OrderServiceFallback.class)
public interface OrderService {

    @GetMapping("/payment/info/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/info/timeout/{time}")
    String paymentInfo_TimeOut(@PathVariable("time") Integer time);

    /**
     * 详见  HystrixCommandProperties.class
     * circuitBreaker.enabled 是否开启熔断机制
     * circuitBreaker.requestVolumeThreshold 请求阀值
     * circuitBreaker.errorThresholdPercentage 请求阀值内容错百分比
     * circuitBreaker.sleepWindowInMilliseconds 熔断后恢复时间
     * @param num
     * @return
     */
    @GetMapping("/payment/info/div/{num}")
    String paymentInfo_Div(@PathVariable("num") Integer num);
}
