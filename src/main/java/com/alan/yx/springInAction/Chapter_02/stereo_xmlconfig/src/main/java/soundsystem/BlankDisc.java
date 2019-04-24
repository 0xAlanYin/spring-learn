package com.alan.yx.springInAction.Chapter_02.stereo_xmlconfig.src.main.java.soundsystem;

/**
 * 示例:将字面量注入到构造器中
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

}
