package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zmj
 * @date 2020/8/3 9:39
 * @Description
 */
@RestController
@Slf4j
public class SentinelController {

    @GetMapping("/testA")
    public String TestA() {
        return "succeed get A";
    }

    @GetMapping("/testB")
    public String TestB() {
        return "succeed get B";
    }

    @GetMapping("/testC/{time}")
    public String TestC(@PathVariable("time")Integer time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "succeed get C,time consuming: " + time + "s";
    }

    @GetMapping("/testD/{num}")
    public String TestD(@PathVariable("num")Integer num) {
        int n = 10 / num;
        return "succeed 10 ÷ " + num + " = " + n;
    }

}
