package com.alan.yx.springSource.chapter_6.converter;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

/**
 * 1.定义转换器
 * <p>
 * spring 提供了另一种转换方式:使用 Converter。
 * (类型转换器从 String 转换为 Date)
 *
 * @author yinxing
 * @date 2019/11/20
 */
@Component
public class String2DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        try {
            return DateUtils.parseDate(s, new String[]{"yyyy-MM-dd HH:mm:ss"});
        } catch (ParseException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String2DateConverter converter = new String2DateConverter();
        System.out.println(converter.convert("2019-11-11 11:11:11"));
    }
}
