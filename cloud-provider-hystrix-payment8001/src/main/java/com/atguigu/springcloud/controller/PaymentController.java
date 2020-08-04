package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zmj
 * @date 2020/7/30 15:39
 * @Description
 */
@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/info/div/{num}")
    public String paymentInfo_Div(@PathVariable("num") Integer num) {
        return paymentService.paymentInfo_Div(num);
    }

    @GetMapping("/payment/info/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/payment/info/timeout/{time}")
    public String paymentInfo_TimeOut(@PathVariable("time") Integer time){
        return paymentService.paymentInfo_TimeOut(time);
    }
}
