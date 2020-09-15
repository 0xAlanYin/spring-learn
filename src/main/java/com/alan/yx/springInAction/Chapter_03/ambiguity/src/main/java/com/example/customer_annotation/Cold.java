package com.alan.yx.springInAction.Chapter_03.ambiguity.src.main.java.com.example.customer_annotation;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义 @Qualifier 注解用于解决歧义问题: 不用担心使用默认的 beanId(类名首字母小写)会被重构
 *
 * @author Alan Yin
 * @date 2020/9/14
 */
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD,
        ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Cold {
}
