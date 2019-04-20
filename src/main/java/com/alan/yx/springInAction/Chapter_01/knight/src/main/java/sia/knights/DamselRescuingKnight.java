package com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights;

public class DamselRescuingKnight implements Knight {

    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        //  与RescueDamselQuest 紧耦合
        this.quest = new RescueDamselQuest();
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }

}
