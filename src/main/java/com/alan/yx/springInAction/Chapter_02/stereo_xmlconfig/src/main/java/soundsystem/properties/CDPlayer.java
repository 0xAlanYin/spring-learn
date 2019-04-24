package com.alan.yx.springInAction.Chapter_02.stereo_xmlconfig.src.main.java.soundsystem.properties;

import com.alan.yx.springInAction.Chapter_02.stereo_xmlconfig.src.main.java.soundsystem.CompactDisc;
import com.alan.yx.springInAction.Chapter_02.stereo_xmlconfig.src.main.java.soundsystem.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;

public class CDPlayer implements MediaPlayer {
  private CompactDisc compactDisc;

  @Autowired
  public void setCompactDisc(CompactDisc compactDisc) {
    this.compactDisc = compactDisc;
  }

  public void play() {
    compactDisc.play();
  }

}
