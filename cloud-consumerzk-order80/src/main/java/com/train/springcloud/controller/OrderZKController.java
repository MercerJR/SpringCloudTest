package com.train.springcloud.controller;

import com.train.springcloud.data.Response;
import com.train.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderZKController {

    private static String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zk",String.class);
        return result;
    }

    @GetMapping("/create")
    public Response create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,Response.class);
    }

    @GetMapping("/get/{id}")
    public Response get(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,Response.class);
    }
}
