package com.train.springcloud.service;

import com.train.springcloud.entities.Payment;
import com.train.springcloud.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Mercer JR
 * @Date: 2020/8/26 16:36
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentMapper mapper;

    public int insert(Payment payment){
        return mapper.insert(payment);
    }

    public Payment getPaymentById(Long id){
        return mapper.selectByPrimaryKey(id);
    }
}
