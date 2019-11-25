package com.alan.yx.springSource.chapter_5.aware;

import org.springframework.stereotype.Component;

/**
 * @author yinxing
 * @date 2019/11/19
 */
@Component
public class Hello {

    public void say() {
        System.out.println("hello");
    }
}
