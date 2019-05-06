package com.alan.yx.springInAction.Chapter_04.src.main.java.config;

import com.alan.yx.springInAction.Chapter_04.src.main.java.aop.Audience;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yinxing
 * @date 2019/4/26
 */
@Configuration
@ComponentScan
// 启用 AspectJ 自动代理
@EnableAspectJAutoProxy
public class ConcertConfig {

    @Bean
    public Audience Audience() {
        return new Audience();
    }
}
