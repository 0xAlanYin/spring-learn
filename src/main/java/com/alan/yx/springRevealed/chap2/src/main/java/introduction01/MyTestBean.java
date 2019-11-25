package com.alan.yx.springRevealed.chap2.src.main.java.introduction01;

/**
 * @author yinxing
 * @date 2019/11/21
 */

public class MyTestBean {

    private String testName = "testName";

    public String getTestName() {
        System.out.println("getTestName");
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

}
