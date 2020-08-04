package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author zmj
 * @date 2020/8/2 11:02
 * @Description
 */
@Slf4j
@RestController
public class OrderController {

    @Value("${com.atguigu.springcloud.service-url.nacos-user-com.atguigu.springcloud.service}")
    private String serverUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serverUrl + "/payment/get/" + id, String.class);
    }

}
