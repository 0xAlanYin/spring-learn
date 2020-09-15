package com.alan.yx.springInAction.Chapter_03.scope.src.test.java.com.myapp;

import com.alan.yx.springInAction.Chapter_03.scope.src.main.java.com.myapp.Notepad;
import com.alan.yx.springInAction.Chapter_03.scope.src.main.java.com.myapp.UniqueThing;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ExplicitConfig {

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public Notepad notepad() {
    return new Notepad();
  }
  
  @Bean
  public UniqueThing unique() {
    return new UniqueThing();
  }
  
}
