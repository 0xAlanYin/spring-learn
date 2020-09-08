package com.example.demo.controller.other;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Alan Yin
 * @date 2020/2/12
 */
@ConfigurationProperties("test1")
public class ConditionSample {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
