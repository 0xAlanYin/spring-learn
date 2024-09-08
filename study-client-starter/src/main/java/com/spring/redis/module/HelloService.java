package com.spring.redis.module;

/**
 * 第 1 步: 定义一个接口，可以认为它是当前独立业务开发模块对外暴露的可以直接调用接口
 * <p>
 * 我们自定义的 spring starter 实现
 * </p>
 *
 * @author yinxing
 * @date 2019/12/5
 */

public interface HelloService {

    String sayHello();
}
