package com.hello.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alan Yin
 * @date 2020/2/12
 */
@Configuration
public class ConfigInit {

    @Bean
    public ConditionSample conditionSample(){
        return new ConditionSample();
    }

}
