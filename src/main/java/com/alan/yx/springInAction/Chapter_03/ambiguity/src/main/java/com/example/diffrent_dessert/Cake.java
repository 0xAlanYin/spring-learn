package com.alan.yx.springInAction.Chapter_03.ambiguity.src.main.java.com.example.diffrent_dessert;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 标注首选 bean : @Primary
 *
 * @author Alan Yin
 * @date 2020/9/14
 */
@Primary
@Component
public class Cake implements Dessert {

    @Override
    public void setDessert() {
        System.out.println("cake");
    }
}
