package com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights;

import java.io.PrintStream;

/**
 * 屠龙探索
 */
public class SlayDragonQuest implements Quest {

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }

}
