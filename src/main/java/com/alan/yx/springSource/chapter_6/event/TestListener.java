package com.alan.yx.springSource.chapter_6.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yinxing
 * @date 2019/11/20
 */
@Component
public class TestListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof TestEvent) {
            TestEvent testEvent = (TestEvent) event;
            testEvent.print();
        }
    }
}
