package com.alan.yx.springSource.chapter_6;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * 测试 BeanPostProcessor： 会在初始化 bean 之前调用
 *
 * @author yinxing
 * @date 2019/11/20
 */
//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("=========postProcessBeforeInstantiation=========");
        return null;
    }
}
