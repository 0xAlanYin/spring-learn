package com.alan.yx.springInAction.Chapter_03.ambiguity.src.main.java.com.example.diffrent_dessert;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Alan Yin
 * @date 2020/9/14
 */
@Component
@Qualifier("cold")
public class IceCream implements Dessert {

    @Override
    public void setDessert() {
        System.out.println("IceCream");
    }

}