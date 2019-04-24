package com.alan.yx.springInAction.Chapter_02.stereo_xmlconfig.src.main.java.soundsystem;

public class SgtPeppers implements CompactDisc {

  private String title = "Sgt. Pepper's Lonely Hearts Club Band";  
  private String artist = "The Beatles";
  
  public void play() {
    System.out.println("Playing " + title + " by " + artist);
  }

}
