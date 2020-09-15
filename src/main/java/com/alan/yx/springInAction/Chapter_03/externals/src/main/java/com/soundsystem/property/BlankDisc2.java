package com.alan.yx.springInAction.Chapter_03.externals.src.main.java.com.soundsystem.property;


import org.springframework.beans.factory.annotation.Value;

/**
 * @Value注解 完成属性注入
 */
public class BlankDisc2 {

    private final String title;
    private final String artist;

    public BlankDisc2(@Value("${disc.title}") String title,
                      @Value("${disc.artist}") String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

}
