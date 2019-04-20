package com.alan.yx.springInAction.Chapter_01.knight.src.test.java.sia.knights;

import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.BraveKnight;
import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.Knight;
import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.Quest;
import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.PrintStream;


@Configuration
public class KnightConfig {

  @Bean
  public Knight knight() {
    return new BraveKnight(quest());
  }

  @Bean
  public Quest quest() {
    return new SlayDragonQuest(stream());
  }

  @Bean
  public PrintStream stream() {
    return new FakePrintStream();
  }

}
