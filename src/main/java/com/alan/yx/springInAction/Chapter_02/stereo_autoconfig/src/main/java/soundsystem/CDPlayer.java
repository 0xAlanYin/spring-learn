package com.alan.yx.springInAction.Chapter_02.stereo_autoconfig.src.main.java.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 程序清单2.6
 * <p>
 * 通过自动装配，将一个CompactDisc注入到CDPlayer之中
 */
@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired
//    @Inject
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired(required = false)
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }

}
