package com.spring.study.module;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 第 2 步
 *
 * @author yinxing
 * @date 2019/12/5
 */
@Component
public class HelloServiceImpl implements HelloService {

    @Value("${study.testStr}")
    private String testStr;

    @Override
    public String sayHello() {
        return "hello" + testStr;
    }

    public String getTestStr() {
        return testStr;
    }

    public HelloServiceImpl setTestStr(String testStr) {
        this.testStr = testStr;
        return this;
    }
}
