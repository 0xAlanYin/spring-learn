package com.alan.yx.springInAction.Chapter_02.stereo_javaconfig.src.test.java.soundsystem;

import com.alan.yx.springInAction.Chapter_02.stereo_javaconfig.src.main.java.soundsystem.CDPlayerConfig;
import com.alan.yx.springInAction.Chapter_02.stereo_javaconfig.src.main.java.soundsystem.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private MediaPlayer player;

    @Test
    public void play() {
        player.play();
        System.out.println("end");
    }

}
