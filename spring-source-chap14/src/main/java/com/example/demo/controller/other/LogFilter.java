package com.example.demo.controller.other;


import javax.servlet.*;
import java.io.IOException;

/**
 * @author Alan Yin
 * @date 2020/3/30
 */

public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 在创建 Filter 时自动调用
        // 其中 filterConfig 包含这个 Filter 的配置参数，比如 name (从配置文件读取)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤客户端发送的请求");
        chain.doFilter(request,response);
        System.out.println("过滤发送给客户端的响应");
    }

    @Override
    public void destroy() {
        // 销毁 Filter 时调用
    }
}
