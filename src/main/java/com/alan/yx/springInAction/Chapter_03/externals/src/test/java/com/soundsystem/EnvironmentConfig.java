package com.alan.yx.springInAction.Chapter_03.externals.src.test.java.com.soundsystem;

import com.alan.yx.springInAction.Chapter_03.externals.src.main.java.com.soundsystem.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * 程序清单3.7 使用@PropertySource注解和Environment
 */
@Configuration
// 声明属性源
@PropertySource("classpath:/com/soundsystem/app.properties")
public class EnvironmentConfig {

  @Autowired
  Environment env;
  
  @Bean
  public BlankDisc blankDisc() {
    return new BlankDisc(
            // 检索属性值
        env.getProperty("disc.title"),
        env.getProperty("disc.artist"));
  }
  
}
