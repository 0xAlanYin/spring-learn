package com.alan.yx.springInAction.Chapter_01.knight.src.test.java.sia.knights;

import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.BraveKnight;
import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.Quest;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQuest = mock(Quest.class);
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }

}
