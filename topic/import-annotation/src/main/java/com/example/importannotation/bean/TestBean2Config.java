package com.example.importannotation.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yinxing
 * @date: 2019/10/13
 */
@Configuration
public class TestBean2Config {

    @Bean
    public TestBean2 testBean2(){
        return new TestBean2();
    }
}
