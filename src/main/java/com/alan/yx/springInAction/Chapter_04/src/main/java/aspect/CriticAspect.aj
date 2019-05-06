package com.alan.yx.springInAction.Chapter_04.src.main.java.aspect;

/**
 * 程序清单4.15 使用AspectJ实现表演的评论员
 * @author yinxing
 * @date 2019/4/26
 */

public aspect CriticAspect {

    public CriticAspect() {
    }

    pointcut performance():execution(* perform(..));

//    afterReturning(): performance(){
//        System.out.println(CriticismEngineImpl.getCriticism());
//    }

    private CriticismEngine criticEngine;

    public void setCriticEngine(CriticismEngine criticEngine){
        // 注入 CriticismEngineImpl
        this.criticEngine = criticEngine;
    }
}
