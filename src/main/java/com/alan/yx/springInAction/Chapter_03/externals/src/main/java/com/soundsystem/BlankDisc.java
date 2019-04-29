package com.alan.yx.springInAction.Chapter_03.externals.src.main.java.com.soundsystem;


public class BlankDisc {

  private final String title;
  private final String artist;

  public BlankDisc(String title, String artist) {
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
