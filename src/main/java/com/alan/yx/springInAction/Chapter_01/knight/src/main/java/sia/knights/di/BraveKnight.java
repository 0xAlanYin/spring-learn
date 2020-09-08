package com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.di;

/**
 * 依赖注入的正面例子(这里使用的是构造器注入（constructor injection）)
 */
public class BraveKnight implements Knight {

    private Quest quest;

    /**
     * Quest 被注入进来：Quest 是一个接口，没有依赖任何具体实现类，这样就实现了解耦合
     *
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
