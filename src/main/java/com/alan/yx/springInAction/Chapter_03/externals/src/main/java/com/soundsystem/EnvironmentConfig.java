package com.alan.yx.springInAction.Chapter_03.externals.src.main.java.com.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * 程序清单3.7 使用@PropertySource注解和Environment
 * <p>
 * 属性文件(app.properties)会加载到Spring的Environment中，稍后可以从这里检索属性
 */
@Configuration
// 声明属性源
@PropertySource("classpath:/com/soundsystem/app.properties")
public class EnvironmentConfig {

    @Autowired
    Environment env;

    @Bean
    public BlankDisc blankDisc() {
        // 从属性文件中得到的是一个String类型的值，那么在使用之前还需要将其转换为Integer类型。
        // 但是，如果使用重载形式的getProperty()的话，就能非常便利地解决这个问题：
        int dbVonnectCount = env.getProperty("db.connection.count", Integer.class, 30);
        boolean exisit = env.containsProperty("db.test");

        return new BlankDisc(
                // 检索属性值
                env.getProperty("disc.title"),
                env.getProperty("disc.artist"));
    }


}
