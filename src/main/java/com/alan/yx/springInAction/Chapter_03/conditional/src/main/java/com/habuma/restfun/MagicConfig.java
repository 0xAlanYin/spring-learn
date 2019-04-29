package com.alan.yx.springInAction.Chapter_03.conditional.src.main.java.com.habuma.restfun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 程序清单3.4 条件化地配置bean
 */
@Configuration
public class MagicConfig {

    @Bean
    // 有条件的创建bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean() {
        return new MagicBean();
    }

}