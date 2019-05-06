package com.alan.yx.springInAction.Chapter_04.src.main.java.aop;

import com.alan.yx.springInAction.Chapter_04.src.main.java.DefaultEncoreable;
import com.alan.yx.springInAction.Chapter_04.src.main.java.Encoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author yinxing
 * @date 2019/4/26
 */

@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "com.alan.yx.springInAction.Chapter_04.src.main.java.Performance+",
            defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;

}
