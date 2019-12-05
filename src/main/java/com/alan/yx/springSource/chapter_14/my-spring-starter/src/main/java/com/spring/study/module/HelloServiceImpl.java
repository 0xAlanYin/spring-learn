package com.spring.study.module;

import org.springframework.stereotype.Component;

/**
 * 第 2 步
 * @author yinxing
 * @date 2019/12/5
 */
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "hello";
    }
}
