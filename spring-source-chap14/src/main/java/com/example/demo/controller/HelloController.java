package com.example.demo.controller;

import com.example.demo.controller.other.ConditionSample;
import com.spring.study.module.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用自定义 starter 演示
 *
 * @author yinxing
 * @date 2019/12/5
 */

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private ConditionSample conditionSample;

    @RequestMapping(value = "/hello")
    public String hello() {
        System.out.println("1");
        System.out.println(conditionSample.getName());
        System.out.println(conditionSample.getAge());
        return "hello spring";
    }

    @RequestMapping(value = "/hello2")
    public String hello2() {
        return helloService.sayHello();
    }
}
