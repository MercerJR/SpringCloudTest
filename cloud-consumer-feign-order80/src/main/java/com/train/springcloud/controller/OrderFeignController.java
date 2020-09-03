package com.train.springcloud.controller;

import com.train.springcloud.data.Response;
import com.train.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Mercer JR
 * @Date: 2020/9/3 19:00
 */
@RestController
@RequestMapping("/consumer/payment")
public class OrderFeignController {
    @Resource
    private PaymentFeignService feignService;

    @GetMapping(value = "/get/{id}")
    public Response getPayment(@PathVariable("id") Long id){
        return feignService.getPayment(id);
    }

}
