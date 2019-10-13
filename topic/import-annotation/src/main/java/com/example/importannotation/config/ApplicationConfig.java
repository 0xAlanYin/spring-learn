package com.example.importannotation.config;

import com.example.importannotation.bean.TestBean1;
import com.example.importannotation.bean.TestBean2Config;
import com.example.importannotation.bean.TestImportBeanDefinitionRegistrar;
import com.example.importannotation.bean.TestImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: yinxing
 * @date: 2019/10/13
 */
@Import({TestBean1.class, TestBean2Config.class, TestImportSelector.class, TestImportBeanDefinitionRegistrar.class})
@Configuration
public class ApplicationConfig {

}
