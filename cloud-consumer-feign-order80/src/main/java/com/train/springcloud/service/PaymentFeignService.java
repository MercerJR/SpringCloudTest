package com.train.springcloud.service;

import com.train.springcloud.data.Response;
import com.train.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Mercer JR
 * @Date: 2020/9/3 18:54
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    Response getPayment(@PathVariable("id") Long id);
}
