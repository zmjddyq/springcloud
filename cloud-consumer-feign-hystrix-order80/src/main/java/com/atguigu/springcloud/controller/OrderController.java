package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.OrderService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zmj
 * @date 2020/7/30 15:53
 * @Description
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/consumer/payment/info/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return orderService.paymentInfo_OK(id);
    }

/*    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Hander",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
    })*/
    @GetMapping("/consumer/payment/info/timeout/{time}")
    public String paymentInfo_TimeOut(@PathVariable("time") Integer time){
        return orderService.paymentInfo_TimeOut(time);
    }

    /**
     * 精准兜底
     * @param
     * @return
     */
/*    public String paymentInfo_TimeOut_Hander(@PathVariable("time") Integer time) {
        return "响应超时或者服务器出现异常，请稍后再试 线程名: " + Thread.currentThread().getName() + "响应时间: " + time;
    }*/
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "20000"),
    })
    @GetMapping("/consumer/payment/info/div/{num}")
    public String paymentInfo_Div(@PathVariable("num") Integer num) {
        return orderService.paymentInfo_Div(num);
    }
}
