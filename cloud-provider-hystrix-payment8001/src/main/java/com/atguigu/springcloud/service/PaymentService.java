package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zmj
 * @date 2020/7/30 15:34
 * @Description
 */
@Service
public class PaymentService {

    public String paymentInfo_Div(Integer num) {
        int result = 10 / num;
        return "succeed: 10 ÷ " + num + " = " + result;
    }

    public String paymentInfo_OK(Integer id){
        return "线程池:  "+Thread.currentThread().getName()+"  paymentInfo_OK,id:  "+id+"\t"+"O(∩_∩)O哈哈~";
    }

/*    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_fallback",commandProperties = {
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })*/
    public String paymentInfo_TimeOut(Integer time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  "+Thread.currentThread().getName()+"\t"+"O(∩_∩)O哈哈~"+"  延时(秒): " + time;
    }

/*    public String paymentInfo_TimeOut_fallback(Integer time){
        return "线程池:  "+Thread.currentThread().getName()+"\t嘤嘤嘤~响应超时或系统出错，请稍后再试o(╥﹏╥)o，响应时间为： " + time;
    }*/

}
