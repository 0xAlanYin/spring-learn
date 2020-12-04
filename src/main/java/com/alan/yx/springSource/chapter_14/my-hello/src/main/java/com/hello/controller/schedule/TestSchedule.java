package com.hello.controller.schedule;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by yangy on 2020/11/2.
 */
@Component
@Slf4j
public class TestSchedule {

    @Scheduled(fixedRate = 6000)
    public void task1() {
        log.info("task1 开始时间:{}", System.currentTimeMillis());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("task1 结束时间:{}", System.currentTimeMillis());
    }

    @Scheduled(fixedRate = 6100)
    public void task2() {
        log.info("task2 开始时间:{}", System.currentTimeMillis());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("task2 结束时间:{}", System.currentTimeMillis());
    }


}
