package com.alan.yx.springInAction.Chapter_03.spel;

/**
 * spring 表达式语言演示
 *
 * @author Alan Yin
 * @date 2020/9/15
 */

public class SPELDemo {

    /**
     * I.SpEL样例
     *
     *  #{1}
     *
     *  #{T(System).currentTimeMills}
     *     ==> T()表达式会将java.lang.System视为Java中对应的类型，因此可以调用其static修饰的currentTimeMillis()方法
     *
     *  #{sgtPeppers.artist}
     *     ==> 会计算得到ID为sgtPeppers的bean的artist属性
     *
     *  #{systemProperties['disc.title']}
     *      ==> 通过systemProperties对象引用系统属性
     */

    /**
     * II.表示字面值
     *
     *  #{3.1415926}    ==> 表示浮点值
     *
     *  #{9.87E4}   ==>表达式计算得到的值就是98,700
     *
     *  #{'Hello'}  ==>计算String类型的字面值
     *
     *  #{false}    ==>字面值true和false的计算结果就是它们对应的Boolean类型的值
     *
     */
}
