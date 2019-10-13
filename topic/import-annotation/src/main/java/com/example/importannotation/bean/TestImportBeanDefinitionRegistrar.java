package com.example.importannotation.bean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Import 作用4：导入ImportBeanDefinitionRegistrar的实现类
 *
 * @author: yinxing
 * @date: 2019/10/13
 */
public class TestImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition(TestBean4.class);
        registry.registerBeanDefinition("testBean4", beanDefinition);
    }
}
