package com.alan.yx.springInAction.Chapter_02.stereo_autoconfig.src.main.java.soundsystem;

import org.springframework.stereotype.Component;

/**
 * 示例2.2
 * <p>
 * 带有@Component注解的CompactDisc实现类SgtPeppers
 */
@Component
// 给 bean 指定自定义名字，默认是类名首字母小写
// nt("lonelyHeartsClub")
//@Named("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";

    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("\n"+"Playing " + title + " by " + artist);
    }

}
