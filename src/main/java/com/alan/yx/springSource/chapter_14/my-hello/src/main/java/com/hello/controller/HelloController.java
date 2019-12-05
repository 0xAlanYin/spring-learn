package com.hello.controller;

import com.spring.study.module.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinxing
 * @date 2019/12/5
 */

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value="/hello")
    public String hello(){
        return "hello spring";
    }

    @RequestMapping(value="/hello2")
    public String hello2(){
        return helloService.sayHello();
    }
}
