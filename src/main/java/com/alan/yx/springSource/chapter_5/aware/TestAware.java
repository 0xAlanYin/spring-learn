package com.alan.yx.springSource.chapter_5.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @author yinxing
 * @date 2019/11/19
 */
@Component
public class TestAware implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void testAware1() {
        // 通过 hello 这个 bean id 从 beanFactory 获取实例
        Hello hello = (Hello) beanFactory.getBean("hello");
        hello.say();
    }
}
