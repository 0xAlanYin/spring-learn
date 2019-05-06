package com.alan.yx.springInAction.Chapter_04.src.main.java.aspect;

/**
 * @author yinxing
 * @date 2019/4/26
 */

public class CriticismEngineImpl implements CriticismEngine {

    public CriticismEngineImpl() {
    }

    private String[] criticismPool;

    public String getCriticismEngine() {
        int i = (int) (Math.random() * 3);
        return criticismPool[i];
    }

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
