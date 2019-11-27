package com.alan.yx.springSource.chapter_3.lookup_method;

/**
 * 2. 创建其子类并覆盖showMe方法。
 *
 * @author yinxing
 * @date 2019/11/27
 */

public class Student extends User {

    @Override
    public void showMe() {
        System.out.println("i am Student");
    }
}
