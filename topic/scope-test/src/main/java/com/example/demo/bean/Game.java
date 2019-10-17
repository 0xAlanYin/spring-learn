package com.example.demo.bean;

/**
 * @author yinxing
 * @date 2019/10/16
 */

public class Game implements Watch {

    public Game() {
        System.out.println("Game construct");
    }

    @Override
    public void watchMovie() {
        System.out.println("I like watching games!");
    }
}
