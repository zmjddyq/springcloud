package com.atguigu.springcloud.service;

import com.atguigu.springcloud.pojo.Order;

/**
 * @author zmj
 * @date 2020/8/4 14:23
 * @Description
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);
}
