package com.alan.yx.springSource.chapter_6;

import java.util.Locale;

/**
 * 国际化
 *
 * @author yinxing
 * @date 2019/11/20
 */

public class LocaleDemo {

    public static void test(){
        // 1.带有语言和国家/地区信息的本地化对象
        Locale locale1 = new Locale("zh","CN");

        // 2.只有语言信息的本地化对象
        Locale locale2 = new Locale("zh");

        // 3. 等同于 1
        Locale locale3 = Locale.CHINA;

        // 4.等同于 2
        Locale locale4 = Locale.CHINESE;

        // 5.获取本地系统默认的本地对象
        Locale locale5 = Locale.getDefault();

        System.out.println(locale1.getLanguage());
    }

    public static void main(String[] args) {
        test();
    }
}
