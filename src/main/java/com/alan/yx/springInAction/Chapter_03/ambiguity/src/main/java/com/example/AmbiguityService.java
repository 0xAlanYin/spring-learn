package com.alan.yx.springInAction.Chapter_03.ambiguity.src.main.java.com.example;

import com.alan.yx.springInAction.Chapter_03.ambiguity.src.main.java.com.example.diffrent_dessert.Dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 因为存在歧义，Spring会抛出 NoUniqueBeanDefinitionException
 *
 * @author Alan Yin
 * @date 2020/9/14
 */
@Service
public class AmbiguityService {

    /**
     * 方式1: 使用 @Primary 注解
     */
    @Autowired
    private Dessert dessert;

    @Autowired
    @Qualifier("cold")
    private Dessert dessert2;

}
