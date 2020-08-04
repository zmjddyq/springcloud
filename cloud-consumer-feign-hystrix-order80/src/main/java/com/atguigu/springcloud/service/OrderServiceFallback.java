package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

/**
 * @author zmj
 * @date 2020/7/31 8:33
 * @Description
 */
@Component
public class OrderServiceFallback implements OrderService{

    private static final String  FALLBACK_MESSAGE = "响应超时或服务器出现异常，请稍后再试！o(╥﹏╥)o";

    @Override
    public String paymentInfo_OK(Integer id) {
        return FALLBACK_MESSAGE;
    }

    @Override
    public String paymentInfo_TimeOut(Integer time) {
        return FALLBACK_MESSAGE;
    }

    @Override
    public String paymentInfo_Div(Integer num) {
        return FALLBACK_MESSAGE + " 参数: " + num;
    }
}
