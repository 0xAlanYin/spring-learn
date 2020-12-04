package com.alan.yx.springInAction.Chapter_04.src.main.java.aop;

import com.alan.yx.springInAction.Chapter_04.src.main.java.DefaultEncoreable;
import com.alan.yx.springInAction.Chapter_04.src.main.java.Encoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 借助于AOP的引入功能，我们可以不必在设计上侵入性地改变现有的实现，对已有类新增方法实现。
 * 为了实现该功能，我们要创建一个新的切面：
 *
 * @author yinxing
 * @date 2019/4/26
 */

@Aspect
public class EncoreableIntroducer {

    /**
     * - value属性指定了哪种类型的bean要引入该接口。 本例中就是所有实现Performance的类型。（标记符后面的加号表示是Performance的所有子类型，而不是Performance本身。）
     * - defaultImpl属性指定了为引入功能提供实现的类。本例指定的是DefaultEncoreable提供实现。
     * - 注解所标注的静态属性指明了要引入了接口。 本例所引入的是Encoreable接口。
     */
    @DeclareParents(value = "com.alan.yx.springInAction.Chapter_04.src.main.java.Performance+",
            defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;

}
