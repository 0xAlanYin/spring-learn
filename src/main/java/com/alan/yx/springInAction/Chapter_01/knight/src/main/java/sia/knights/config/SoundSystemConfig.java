package com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.alan.yx.springInAction.Chapter_01",
               excludeFilters = { @Filter(Configuration.class) })
public class SoundSystemConfig {

}
