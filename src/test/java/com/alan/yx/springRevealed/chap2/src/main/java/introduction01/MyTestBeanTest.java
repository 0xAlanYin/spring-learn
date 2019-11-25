package com.alan.yx.springRevealed.chap2.src.main.java.introduction01;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

/**
 * @author yinxing
 * @date 2019/11/21
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTestBeanTest {

    @Test
    public void test(){
        BeanFactory bf = new ClassPathXmlApplicationContext("myTestBean.xml");
//        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("myTestBean.xml"));
        MyTestBean myTestBean = (MyTestBean)bf.getBean("myTestBean");
        assertThat(myTestBean.getTestName(), Is.is("testName"));
    }
}