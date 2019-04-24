package com.alan.yx.springInAction.Chapter_02.stereo_mixedconfig.src.main.java.soundsystem;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({CDPlayerConfig.class})
@ImportResource("classpath:cd-config.xml")
//@Import({CDPlayerConfig.class,CDConfig.class})
public class SoundSystemConfig {

}
