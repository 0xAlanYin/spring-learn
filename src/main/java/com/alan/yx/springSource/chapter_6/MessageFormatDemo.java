package com.alan.yx.springSource.chapter_6;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * spring 中国际化资源操作： MessageFormat为例
 *
 * @author yinxing
 * @date 2019/11/20
 */

public class MessageFormatDemo {

    public static void test() {
        // 1.信息格式化串
        String pattern1 = "{0},你好！欢迎你在 {1}来到 {2} 号空间";
        String pattern2 = " At {1,time,short} On {1,date,long} {0} paid {2,number,currency}";

        // 2.用于动态替换占位符的参数
        Object[] params = {"Jack", new GregorianCalendar().getTime(), 1.0E3};

        // 3.使用默认本地化对象格式化信息
        String msg1 = MessageFormat.format(pattern1, params);

        // 4.使用指定的本地化对象格式化信息
        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
        String msg2 = mf.format(params);

        System.out.println(msg1);
        System.out.println(msg2);
    }

    public static void main(String[] args) {
        test();
    }
}
