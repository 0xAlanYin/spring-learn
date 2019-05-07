package com.alan.yx.springInAction.Chapter_07.Spittr.src.main.java.spittr.config;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yinxing
 * @date 2019/4/30
 */

public class MyServlet implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
