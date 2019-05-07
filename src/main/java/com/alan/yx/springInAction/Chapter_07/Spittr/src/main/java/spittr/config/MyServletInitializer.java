package com.alan.yx.springInAction.Chapter_07.Spittr.src.main.java.spittr.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 程序清单7.1 通过实现WebApplicationInitializer来注册Servlet
 * 程序清单7.2 注册Filter的WebApplicationInitializer
 *
 * @author yinxing
 * @date 2019/4/30
 */

public class MyServletInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 注册 Servlet
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
        // 映射 Servlet
        myServlet.addMapping("/custom/**");

        // 注册 Filter
        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
        // 添加 Filter 的映射路径
        myFilter.addMappingForUrlPatterns(null, false, "/custom/**");

    }
}
