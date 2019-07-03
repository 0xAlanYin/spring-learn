package com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.config;

import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.BraveKnight;
import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.Knight;
import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.Quest;
import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 基于 java 配置(也可以使用 xml 配置)
 */
@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

}
