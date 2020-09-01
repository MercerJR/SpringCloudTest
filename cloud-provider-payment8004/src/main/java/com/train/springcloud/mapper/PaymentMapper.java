package com.train.springcloud.mapper;

import com.train.springcloud.entities.Payment;

/**
 * @Author: Mercer JR
 * @Date: 2020/8/26 16:35
 */
//@Mapper
public interface PaymentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}