package com.alan.yx.springInAction.Chapter_04.src.test.java;

import com.alan.yx.springInAction.Chapter_04.src.main.java.CompactDisc;
import com.alan.yx.springInAction.Chapter_04.src.main.java.aop.TrackCounter;
import com.alan.yx.springInAction.Chapter_04.src.main.java.config.TrackCounterConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author yinxing
 * @date 2019/4/26
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= TrackCounterConfig.class)
public class TrackCounterTest {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private TrackCounter counter;

    @Test
    public void testTrackCounter(){
        // 播放磁道
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(4);
        cd.playTrack(4);

        // 断言期望到数量
        assertEquals(1,counter.getPlayCount(1));
        assertEquals(1,counter.getPlayCount(2));
        assertEquals(3,counter.getPlayCount(3));
        assertEquals(2,counter.getPlayCount(4));
        assertEquals(0,counter.getPlayCount(5));
        assertEquals(0,counter.getPlayCount(6));
//        assertEquals(2,counter.getPlayCount(7));
    }
}