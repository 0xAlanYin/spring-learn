package com.alan.yx.springInAction.Chapter_02.stereo_javaconfig.src.main.java.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {

    @Bean
//  @Bean(name = "otherName")
    public CompactDisc compactDsisc() {
        // 可以加入一些处理逻辑
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

//    /**
//     * 随机播放CD
//     *
//     * @return
//     */
//    @Bean
//    public CompactDisc randomCD() {
//        int choice = (int) Math.floor(Math.random() * 4);
//        if(choice==0){
//            return new CompactDiscOne();
//        }else if(choice==1){
//            return new CompactDiscTwo();
//        }else {
//            return new SgtPeppers();
//        }
//    }

}
