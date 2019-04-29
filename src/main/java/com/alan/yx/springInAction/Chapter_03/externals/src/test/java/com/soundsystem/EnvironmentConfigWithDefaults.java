package com.alan.yx.springInAction.Chapter_03.externals.src.test.java.com.soundsystem;

import com.alan.yx.springInAction.Chapter_03.externals.src.main.java.com.soundsystem.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

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
