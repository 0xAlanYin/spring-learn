package com.alan.yx.springInAction.Chapter_03.externals.src.main.java.com.soundsystem.property;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * 从Spring 3.1开始，推荐使用PropertySourcesPlaceholderConfigurer，
 * 因为它能够基于Spring Environment及其属性源来解析占位符。
 *
 * @author Alan Yin
 * @date 2020/9/15
 */
@Configuration
public class PropertySourcesPlaceholderConfigTest {

    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
