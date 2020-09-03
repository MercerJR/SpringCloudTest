package com.train.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Mercer JR
 * @Date: 2020/9/1 10:26
 */
@Configuration
public class MyRule {

    @Bean
    public IRule mySelfRule(){
        return new RandomRule();
    }

}
