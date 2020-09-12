package com.train.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.train.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/payment/hystrix")
@DefaultProperties(defaultFallback = "fallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService service;

    @GetMapping("/ok/{id}")
    public String payment_ok(@PathVariable("id")Integer id){
        String result = service.payment_ok(id);
        return result;
    }

    @GetMapping("/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    @HystrixCommand()
    String payment_timeOut(@PathVariable("id")Integer id){
        String result = service.payment_timeOut(id);
        return result;
    }

    public String paymentInfo_timeOutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " TIMEOUT_HANDLER, id: " + id + "/(ㄒoㄒ)/~~";
    }

    public String fallbackMethod(){
        return "出现异常，请稍后再试";
    }
    //
}
