package com.alan.yx.springInAction.Chapter_02.stereo_mixedconfig.src.main.java.soundsystem;
import org.springframework.beans.factory.annotation.Autowired;

public class CDPlayer implements MediaPlayer {
  private CompactDisc cd;

  @Autowired
  public CDPlayer(CompactDisc cd) {
    this.cd = cd;
  }

  @Autowired
  public void play() {
    cd.play();
  }

}
