package com.alan.yx.springInAction.Chapter_04.src.main.java.config;

import com.alan.yx.springInAction.Chapter_04.src.main.java.CompactDisc;
import com.alan.yx.springInAction.Chapter_04.src.main.java.SgtPeppers;
import com.alan.yx.springInAction.Chapter_04.src.main.java.aop.TrackCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 程序清单4.7 配置TrackCount记录每个磁道播放的次数
 *
 * @author yinxing
 * @date 2019/4/26
 */
@Configuration
// 启用 AspectJ 自动代理
@EnableAspectJAutoProxy
@ComponentScan
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        SgtPeppers sgtPeppers = new SgtPeppers();
        sgtPeppers.setTitle("new title");
        sgtPeppers.setArtist("new artist");
        return sgtPeppers;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
