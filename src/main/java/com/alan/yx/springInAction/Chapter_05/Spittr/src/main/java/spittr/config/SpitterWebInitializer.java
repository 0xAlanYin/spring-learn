package com.alan.yx.springInAction.Chapter_05.Spittr.src.main.java.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.alan.yx.springInAction.Chapter_05.Spittr.src.main.java.spittr.web.WebConfig;

/**
 * 程序清单5.1 配置DispatcherServl
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * 指定配置类
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 将 DispatcherServlet 映射到 "/"
     *
     * 表示它会是应用的默认Servlet。它会处理进入应用的所有请求
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}