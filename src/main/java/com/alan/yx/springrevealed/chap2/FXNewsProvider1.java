package com.alan.yx.springrevealed.chap2;

import com.alan.yx.springrevealed.chap2.support.IFXNewsListen;
import com.alan.yx.springrevealed.chap2.support.IFXNewsPesister;

/**
 * 构造器注入依赖
 * 代码清单2-3FXNewsProvider构造方法定义
 *
 * @author yinxing
 * @date 2019/6/13
 */

public class FXNewsProvider1 {

    private IFXNewsListen newsListen;

    private IFXNewsPesister newsPesister;

    public FXNewsProvider1(IFXNewsListen newsListen, IFXNewsPesister newsPesister) {
        this.newsListen = newsListen;
        this.newsPesister = newsPesister;
    }
}
