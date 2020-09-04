package com.train.springcloud.controller;

import com.train.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/payment/hystrix")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService service;

    @GetMapping("/ok/{id}")
    public String payment_ok(@PathVariable("id")Integer id){
        String result = service.payment_ok(id);
        return result;
    }

    @GetMapping("/timeout/{id}")
    String payment_timeOut(@PathVariable("id")Integer id){
        String result = service.payment_timeOut(id);
        return result;
    }

}
