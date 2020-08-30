package com.train.springcloud.controller;

import com.train.springcloud.data.Response;
import com.train.springcloud.entities.Payment;
import com.train.springcloud.exception.CustomException;
import com.train.springcloud.exception.CustomExceptionType;
import com.train.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Mercer JR
 * @Date: 2020/8/26 16:47
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/create")
    public Response create(@RequestBody Payment payment){
        int result = service.insert(payment);
        log.info("***插入结果：" + payment);
        if (result > 0){
            log.info("serverPort:"+port);
            return new Response().success();
        }else {
            return new Response().validateFailed("操作失败");
        }
    }

    @GetMapping(value = "/get/{id}")
    public Response getPayment(@PathVariable("id") Long id){
        Payment payment = service.getPaymentById(id);
        log.info("***插入结果：" + payment);
        if (payment != null){
            log.info("serverPort:"+port);
            return new Response().success(payment);
        }else {
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR,"操作失败");
        }
    }
}
