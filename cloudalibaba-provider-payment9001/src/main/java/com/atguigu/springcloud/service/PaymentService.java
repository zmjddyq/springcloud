package com.atguigu.springcloud.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author zmj
 * @date 2020/8/2 9:14
 * @Description
 */
@Service
public class PaymentService {

    @Value("${server.port}")
    private String serverPort;

    public String getPayment(Integer id) {
        String order = UUID.randomUUID().toString();
        return "端口： " + serverPort + "请求成功，id为: " + id +"，获取到订单编号： " + order;
    }

}
