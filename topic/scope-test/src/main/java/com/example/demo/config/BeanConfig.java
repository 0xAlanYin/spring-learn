package com.example.demo.config;

import com.example.demo.bean.Game;
import com.example.demo.bean.Movie;
import com.example.demo.bean.Watch;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * @author yinxing
 * @date 2019/10/16
 */

@Configuration
public class BeanConfig {

    @Bean
    public Movie movie() {
        Movie movie = new Movie();
        return movie;
    }

    @Bean
    // 应用启动不会产生真正的实例，只有使用时才产生实例，启动只产生代理===》懒解析
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Game game() {
        Game game = new Game();
        return game;
    }

    @Bean
    public Watch watch() {
        Watch watch = new Movie();
        return watch;
    }

}
