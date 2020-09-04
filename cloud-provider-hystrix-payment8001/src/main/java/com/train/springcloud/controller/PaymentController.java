package com.train.springcloud.controller;

import com.train.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment/hystrix")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ok/{id}")
    public String payment_ok(@PathVariable("id")Integer id){
        String result = service.paymentInfo_ok(id);
        log.info("******result:" + result);
        return result;
    }

    @GetMapping("/timeout/{id}")
    public String payment_timeOut(@PathVariable("id")Integer id){
        String result = service.paymentInfo_timeOut(id);
        log.info("******result:" + result);
        return result;
    }
}
