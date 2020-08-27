package com.train.springcloud.controller;

import com.train.springcloud.data.Response;
import com.train.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

    private static String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/create")
    public Response create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,Response.class);
    }

    @GetMapping("/get/{id}")
    public Response get(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,Response.class);
    }
}
