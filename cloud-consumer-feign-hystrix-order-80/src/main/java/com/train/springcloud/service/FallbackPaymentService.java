package com.train.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
public class FallbackPaymentService implements PaymentHystrixService{
    @Override
    public String payment_ok(Integer id) {
        return "请求错误，请稍后再试";
    }

    @Override
    public String payment_timeOut(Integer id) {
        return "请求错误，请稍后再试";
    }
}
