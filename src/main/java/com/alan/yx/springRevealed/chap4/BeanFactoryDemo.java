//package com.alan.yx.springRevealed.chap4;
//
//import com.alan.yx.springRevealed.support.FXNewsProvider;
//import org.springframework.beans.MutablePropertyValues;
//import org.springframework.beans.PropertyValue;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.config.ConstructorArgumentValues;
//import org.springframework.beans.factory.support.AbstractBeanDefinition;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.beans.factory.support.RootBeanDefinition;
//
///**
// * 代码清单4-4通过编码方式使用BeanFactory实现FX新闻相关类的注册及绑定
// *
// * @author yinxing
// * @date 2019/7/2
// */
//
//public class BeanFactoryDemo {
//
//    public static void main(String[] args) {
//        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
//        BeanFactory container = bindViaCode(beanRegistry);
//        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
//        newsProvider.getAndPersistNews();
//    }
//
//    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {
//        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class, true);
//        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class, true);
//        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class, true);
//
//        // 将bean定义注册到容器中
//        registry.registerBeanDefinition("djNewsProvider", newsProvider);
//        registry.registerBeanDefinition("djListener", newsListener);
//        registry.registerBeanDefinition("djPersister", newsPersister);
//        // 指定依赖关系
//        // 方式1. 可以通过构造方法注入方式
//        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
//        argValues.addIndexedArgumentValue(0, newsListener);
//        argValues.addIndexedArgumentValue(1, newsPersister);
//        newsProvider.setConstructorArgumentValues(argValues);
//        // 方式2. 或者通过setter方法注入方式（将 newsListener 和 newsPersister 注入到 newsProvider）
////        MutablePropertyValues propertyValues = new MutablePropertyValues();
////        propertyValues.addPropertyValue(new PropertyValue("newsListener", newsListener));
////        propertyValues.addPropertyValue(new PropertyValue("newPersistener", newsPersister));
////        newsProvider.setPropertyValues(propertyValues);
//        // 绑定完成
//        return (BeanFactory) registry;
//    }
//
//}
