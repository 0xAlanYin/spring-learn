package com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author yinxing
 * @date 2019/4/20
 */

public class MyApplicationContext {

    ApplicationContext context1 = new FileSystemXmlApplicationContext("c:/test.xml");

    ApplicationContext context2 = new ClassPathXmlApplicationContext("test.xml");

    ApplicationContext context3 = new AnnotationConfigApplicationContext("com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.config.KnightConfig");
}
