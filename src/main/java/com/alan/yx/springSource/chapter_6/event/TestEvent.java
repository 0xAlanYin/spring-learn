package com.alan.yx.springSource.chapter_6.event;

import org.springframework.context.ApplicationEvent;

/**
 * 1.定义监听事件
 * <p>
 * 当程序运行时， Spring会将发出的 TestEvent事件转给我们自定义的 TestListener 进行进一 步处理
 *
 * @author yinxing
 * @date 2019/11/20
 */
public class TestEvent extends ApplicationEvent {

    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public TestEvent(Object source) {
        super(source);
    }

    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public void print() {
        System.out.println(msg);
    }
}
