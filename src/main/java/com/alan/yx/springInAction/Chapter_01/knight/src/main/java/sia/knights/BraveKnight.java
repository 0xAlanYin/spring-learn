package com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights;
  
public class BraveKnight implements Knight {

  private Quest quest;

  /**
   * Quest 被注入进来
   * @param quest
   */
  public BraveKnight(Quest quest) {
    this.quest = quest;
  }

  @Override
  public void embarkOnQuest() {
    quest.embark();
  }

}
