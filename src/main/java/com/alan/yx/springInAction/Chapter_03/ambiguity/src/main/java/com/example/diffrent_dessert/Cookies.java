package com.alan.yx.springInAction.Chapter_03.ambiguity.src.main.java.com.example.diffrent_dessert;

import org.springframework.stereotype.Component;

/**
 * @author Alan Yin
 * @date 2020/9/14
 */
@Component
public class Cookies implements Dessert {

    @Override
    public void setDessert() {
        System.out.println("Cookies");
    }

}