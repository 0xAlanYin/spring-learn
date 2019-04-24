package com.alan.yx.springInAction.Chapter_02.stereo_mixedconfig.src.main.java.soundsystem;

import java.util.List;

/**
 * 示例：装配集合
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    /**
     * 磁道
     */
    private List<String> tracks;

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }

}