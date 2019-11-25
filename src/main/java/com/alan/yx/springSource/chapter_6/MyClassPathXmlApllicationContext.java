package com.alan.yx.springSource.chapter_6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 扩展 ClassPathXmlApplicationContext 的示例
 * <p>
 * 说明 spring 框架设计的灵活性和强大
 *
 * @author yinxing
 * @date 2019/11/19
 */

public class MyClassPathXmlApllicationContext extends ClassPathXmlApplicationContext {

    @Override
    protected void initPropertySources() {
        super.initPropertySources();
        // 自定义添加验证要求
        getEnvironment().setRequiredProperties("var");
    }
}

/**
 * 假如现在有这样一个需求，工程在运行过程中用到的某个设置(例如 VAR )是从系统环境 变量中取得的，
 * 而如果用户没有在系统环境变量中配置这个参数，那么工程可能不会工作。
 * 这一要求可能会有各种各样的解决办法，当然，在 spring 中可以这样做，你可以直接修改 Spring 的源码，例如修改 ClassPathXmlApplicationContext。
 * 当然，最好的办法还是对源码进行扩展 ，我们可以自定义类,如上所示
 * <p>
 * 我们 自定义了继承自 ClassPathXmlApplicationContext 的 MyClassPathXmlApplicationContext, 并重写了 initPropertySources 方法，
 * 在方法中添加了我们的个性化需求，那么在验证的时候也就是程序走到 getEnvironment().validateRequiredProperties()代码的时候，
 * 如果系统并没有检测到对 应 VAR 的环境变 量 ，那么将抛出异常 。当然我们还 需要在使用的时候替换掉原有的ClassPathXmlApplicationConte：
 * <p>
 * ApplicationContext bf = new MyClassPathXm工ApplicationContext("test/custom/test.xml”);
 * User user=(User) bf.getBean(”testbean”);
 **/