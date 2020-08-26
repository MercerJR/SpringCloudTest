package com.train.springcloud.controller;

import com.train.springcloud.data.Response;
import com.train.springcloud.entities.Payment;
import com.train.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/create")
    public Response create(Payment payment){
        int result = service.insert(payment);
        log.info("***插入结果：" + payment);
        if (result > 0){
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
            return new Response().success(payment);
        }else {
            return new Response().validateFailed("操作失败");
        }
    }
}
