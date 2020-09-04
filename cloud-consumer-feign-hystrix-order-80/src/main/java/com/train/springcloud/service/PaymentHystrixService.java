package com.train.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String payment_ok(@PathVariable("id")Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String payment_timeOut(@PathVariable("id")Integer id);

}
