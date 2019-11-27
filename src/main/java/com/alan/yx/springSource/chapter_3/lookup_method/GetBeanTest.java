package com.alan.yx.springSource.chapter_3.lookup_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 3. 创建调用方法。
 *
 * @author yinxing
 * @date 2019/11/27
 */

public abstract class GetBeanTest {

    public void showMe() {
        this.getBean().showMe();
    }

    public abstract User getBean();


    /**
     * 4. 创建测试方法。
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/alan/yx/springSource/chapter_3/lookup_method/lookupTest.xml");
        GetBeanTest getBeanTest = (GetBeanTest) context.getBean("getBeanTest");
        getBeanTest.showMe();
    }
}
