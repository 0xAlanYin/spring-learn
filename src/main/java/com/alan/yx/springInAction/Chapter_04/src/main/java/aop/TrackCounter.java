package com.alan.yx.springInAction.Chapter_04.src.main.java.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 程序清单4.6 使用参数化的通知来记录磁道播放的次数
 *
 * @author yinxing
 * @date 2019/4/26
 */
@Component
@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>(16);

    /**
     * 通知方法
     *
     * @param trackNumber
     */
    @Pointcut("execution(* com.alan.yx.springInAction.Chapter_04.src.main.java.CompactDisc.playTrack(int))" +
            "&& args(trackNumber)")
    public void trackPlayed(int trackNumber) {
    }

    /**
     * 播放前，为该磁道计数
     *
     * @param trackNumber
     */
    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        int cuurentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, cuurentCount + 1);
    }

    /**
     * 获取播放次数
     *
     * @param trackNumber
     * @return
     */
    public int getPlayCount(int trackNumber) {
        return trackCounts.containsValue(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }

}
