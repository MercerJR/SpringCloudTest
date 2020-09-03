package com.train.springcloud.controller;

import com.train.springcloud.data.Response;
import com.train.springcloud.entities.Payment;
import com.train.springcloud.exception.CustomException;
import com.train.springcloud.exception.CustomExceptionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

    private static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

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

    @GetMapping("/getEntity/{id}")
    public Response getEntity(@PathVariable("id")Long id){
        ResponseEntity<Response> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, Response.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR,"调用错误");
        }
    }
}
