package com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.aop;

import com.alan.yx.springInAction.Chapter_01.knight.src.test.java.sia.knights.FakePrintStream;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;

/**
 * 吟游诗人切面 aop
 *
 * @author Alan Yin
 * @date 2020/9/8
 */
@Scope
@Aspect
public class MinstrelAspect {

    private Minstrel minstrel;

    public MinstrelAspect() {
        this.minstrel = new Minstrel(new FakePrintStream());
    }

    @Pointcut("execution(* com.alan.yx.springInAction.Chapter_01.knight.src.main.java.sia.knights.di.BraveKnight.embarkOnQuest(..))")
    public void pointcut() {
    }

//    @Before("pointcut()")
//    public Object before(ProceedingJoinPoint joinPoint) {
//        minstrel.singBeforeQuest();
//        try {
//            return joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            return "error";
//        }
//    }
//
//    @After("pointcut()")
//    public Object after(ProceedingJoinPoint joinPoint) {
//        try {
//            Object object = joinPoint.proceed();
//            minstrel.singAfterQuest();
//            return object;
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            return "error";
//        }
//    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object object = null;
        try {
            minstrel.singBeforeQuest();
            object = joinPoint.proceed();
            minstrel.singAfterQuest();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }

}
