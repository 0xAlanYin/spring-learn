package com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.aop;

import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.di.Knight;
import com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.di.Quest;

/**
 * 示例 1.10
 *
 * @author yinxing
 * @date 2019/4/20
 */

public class BraveKnightWithoutAOP implements Knight {

    private Quest quest;

    private Minstrel minstrel;

    public BraveKnightWithoutAOP(Quest quest, Minstrel minstrel) {
        this.quest = quest;
        this.minstrel = minstrel;
    }

    /**
     * Knight 不应该管理 Minstrel
     * <p>
     * 骑士应该专注于探险，不应该关注吟唱诗人
     */
    @Override
    public void embarkOnQuest() {
        minstrel.singBeforeQuest();
        quest.embark();
        minstrel.singAfterQuest();
    }
}
