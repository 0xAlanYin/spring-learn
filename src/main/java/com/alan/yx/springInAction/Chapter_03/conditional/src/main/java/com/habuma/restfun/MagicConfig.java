package com.alan.yx.springInAction.Chapter_03.conditional.src.main.java.com.habuma.restfun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 程序清单3.4 条件化地配置bean
 * <p>
 * 假设有一个名为MagicBean的类，我们希望只有设置了magic环境属性的时候，Spring才会实例化这个类。如果环境中没有这个属性，那么MagicBean将会被忽略。
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