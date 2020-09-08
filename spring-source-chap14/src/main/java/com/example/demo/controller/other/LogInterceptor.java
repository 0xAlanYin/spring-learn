package com.example.demo.controller.other;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alan Yin
 * @date 2020/3/30
 */

public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截客户端发送的请求");
        // ...
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截发送客户端的响应");
        // ...

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("这里总是被执行");
    }

}

/**
 * <mvc:interceptors>
 * <mvc:interceptor>
 * <mvc:mapping path="/*"/>
 * <bean class="com.xyz.cd.LogInterceptor"/>
 * </mvc:interceptor>
 * </mvc:interceptors>
 */
