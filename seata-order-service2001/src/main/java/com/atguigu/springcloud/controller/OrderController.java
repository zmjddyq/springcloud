package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.pojo.Order;
import com.atguigu.springcloud.service.OrderService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zmj
 * @date 2020/8/4 14:55
 * @Description
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.createOrder(order);
        return new CommonResult(200,"订单创建成功");
    }
}
