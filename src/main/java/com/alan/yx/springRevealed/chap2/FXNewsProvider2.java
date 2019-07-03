package com.alan.yx.springRevealed.chap2;

import com.alan.yx.springRevealed.support.IFXNewsListen;
import com.alan.yx.springRevealed.support.IFXNewsPesister;

/**
 * setter方法注入依赖
 * 代码清单2-4添加了setter方法声明的FXNewsProvider
 *
 * @author yinxing
 * @date 2019/6/13
 */

public class FXNewsProvider2 {

    private IFXNewsListen newsListen;

    private IFXNewsPesister newsPesister;

    public IFXNewsListen getNewsListen() {
        return newsListen;
    }

    public void setNewsListen(IFXNewsListen newsListen) {
        this.newsListen = newsListen;
    }

    public IFXNewsPesister getNewsPesister() {
        return newsPesister;
    }

    public void setNewsPesister(IFXNewsPesister newsPesister) {
        this.newsPesister = newsPesister;
    }
}
