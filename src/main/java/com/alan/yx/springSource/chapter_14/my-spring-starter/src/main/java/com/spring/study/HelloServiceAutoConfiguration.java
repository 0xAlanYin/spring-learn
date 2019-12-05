package com.spring.study;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 第 3 步
 * HelloServiceAutoConfiguration 类中并没有逻辑实现，
 * 它存在的目的仅仅是通过注解进行配置的声明，我们可以在 ComponentScan 中加入这个模块的容器扫描路径 。
 *
 * @author yinxing
 * @date 2019/12/5
 */

@Configuration
@ComponentScan({"com.spring.study.module"})
public class HelloServiceAutoConfiguration {

}

/**
 * 第 4 步
 * 最后一步：那就是声明这个配置文件的路径，在 Spring 的跟路径下建立 META-INF/spring.factories 文件
 * 并声明配置项路径
 */