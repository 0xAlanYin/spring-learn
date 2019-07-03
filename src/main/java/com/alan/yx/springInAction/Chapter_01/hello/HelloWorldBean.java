package com.alan.yx.springInAction.Chapter_01.hello;

/**
 * 虽然这段代码使用了 Spring， 但是是非侵入式的（这就是 Spring 的魅力呀）
 *
 * @author yinxing
 * @date 2019/4/20
 */

public class HelloWorldBean {

    public String sayHello() {
        return "hello world";
    }
}
