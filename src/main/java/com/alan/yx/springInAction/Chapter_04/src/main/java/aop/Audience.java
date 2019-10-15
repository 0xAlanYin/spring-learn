package com.alan.yx.springInAction.Chapter_04.src.main.java.aop;

import org.aspectj.lang.annotation.*;

/**
 * 使用 @Aspect 定义切面
 *
 * @author yinxing
 * @date 2019/4/26
 */

@Aspect
public class Audience {

    /**
     * 表演之前
     */
    @Before("execution(* com.alan.yx.springInAction.Chapter_04.src.main.java.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("silenceCellPhones");
    }

    /**
     * 表演之前
     */
    @Before("execution(* com.alan.yx.springInAction.Chapter_04.src.main.java.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("takeSeats");
    }

    /**
     * 表演之后（鼓掌）
     */
    @AfterReturning("execution(* com.alan.yx.springInAction.Chapter_04.src.main.java.Performance.perform(..))")
    public void applause() {
        System.out.println("applause");
    }

    /**
     * 表演失败之后(退款)
     */
    @AfterThrowing("execution(* com.alan.yx.springInAction.Chapter_04.src.main.java.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("demandRefund");
    }
}
