package com.alan.yx.springInAction.Chapter_04.src.main.java.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author yinxing
 * @date 2019/4/26
 */
@Aspect
public class Audience2 {

    /**
     * 定义命名的切点
     */
    @Pointcut("execution(* com.alan.yx.springInAction.Chapter_04.src.main.java.Performance.perform(..))")
    public void performance() {
    }

    /**
     * 表演之前
     */
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("silenceCellPhones");
    }

    /**
     * 表演之前
     */
    @Before("performance()")
    public void takeSeats() {
        System.out.println("takeSeats");
    }

    /**
     * 表演之后（鼓掌）
     */
    @AfterReturning("performance()")
    public void applause() {
        System.out.println("applause");
    }

    /**
     * 表演失败之后(退款)
     */
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("demandRefund");
    }

    /**
     * 环绕通知方法【重点】
     * <p>
     * 通知方法中可以做任何的事情，当要将控制权交给被通知的方法时，它需要调用ProceedingJoinPoint的proceed()方法。
     *
     * @param jp
     */
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("silenceCellPhones");
            System.out.println("takeSeats");
            // 调用目标类的方法
            jp.proceed();
            System.out.println("applause");
        } catch (Throwable throwable) {
            System.out.println("demandRefund");
            throwable.printStackTrace();
        }
    }
}
