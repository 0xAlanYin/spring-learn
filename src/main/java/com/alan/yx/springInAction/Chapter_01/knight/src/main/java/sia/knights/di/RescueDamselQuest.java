package com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.di;

import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.di.Quest;

/**
 * 救援行动
 */
public class RescueDamselQuest implements Quest {

    @Override
    public void embark() {
        System.out.println("Embarking on a quest to rescue the damsel.");
    }

}
