package com.example.demo.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * @author yinxing
 * @date 2019/10/16
 */
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class Movie implements Watch {

    public Movie() {
        System.out.println("Movie construct");
    }

    @Override
    public void watchMovie() {
        System.out.println("I like watching movies!");
    }
}
