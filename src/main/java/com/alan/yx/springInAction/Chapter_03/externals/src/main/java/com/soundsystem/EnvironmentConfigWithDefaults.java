package com.alan.yx.springInAction.Chapter_03.externals.src.main.java.com.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 带有默认值的属性配置
 */
@Configuration
public class EnvironmentConfigWithDefaults {

    @Autowired
    Environment env;

    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(
                env.getProperty("disc.title", "Rattle and Hum"),
                env.getProperty("disc.artist", "U2"));
    }

}
