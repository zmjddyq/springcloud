package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zmj
 * @date 2020/7/28 21:08
 * @Description
 */
public interface PaymentService {
    /**
     * 创建订单
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 通过id获取订单
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);
}
