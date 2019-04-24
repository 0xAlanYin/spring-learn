package com.alan.yx.springInAction.Chapter_02.stereo_xmlconfig.src.main.java.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 示例:属性注入的CDPlayer
 */
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }

}
