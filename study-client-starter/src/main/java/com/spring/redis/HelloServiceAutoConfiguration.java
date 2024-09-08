package com.spring.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 第 3 步:让主函数感知,添加自动配置项
 * <p>
 * HelloServiceAutoConfiguration 类中并没有逻辑实现，
 * 它存在的目的仅仅是通过注解进行配置的声明，我们可以在 ComponentScan 中加入这个模块的容器扫描路径。
 * </p>
 *
 * @author yinxing
 * @date 2019/12/5
 */

@Configuration
@ComponentScan({"com.spring.redis.module"})
// 如果配置属性中显示的声明 study.enable=true，则当前的整套体系(即这个 starter)才生效
@ConditionalOnProperty(prefix = "study", name = "enable", havingValue = "true")
public class HelloServiceAutoConfiguration {

}

/**
 * 第 4 步
 * 最后一步就是声明这个配置文件的路径:
 * 在 Spring 的跟路径下建立 META-INF/spring.factories 文件,并声明配置项路径
 */