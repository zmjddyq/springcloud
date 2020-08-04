package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zmj
 * @date 2020/7/28 21:08
 * @Description
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentService {
    /**
     * 创建订单
     * @param payment
     * @return
     */
    @PostMapping("/payment/create")
    CommonResult<Payment> create(Payment payment);

    /**
     * 通过id获取订单
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
