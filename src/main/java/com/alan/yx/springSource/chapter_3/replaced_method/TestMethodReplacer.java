package com.alan.yx.springSource.chapter_3.replaced_method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * 2. 在运行一段时间后需要改变原有的业务逻辑
 *
 * @author yinxing
 * @date 2019/11/28
 */

public class TestMethodReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("I replace the method");
        return null;
    }

    /**
     * 4. 测试。
     */
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/alan/yx/springSource/chapter_3/replaced_method");
        TestChangeMethod testChangeMethod = (TestChangeMethod) context.getBean("testChangeMethod");
        testChangeMethod.changeMe();
    }
}
