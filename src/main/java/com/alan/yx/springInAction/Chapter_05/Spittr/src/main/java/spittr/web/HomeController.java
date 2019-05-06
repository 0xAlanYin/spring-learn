package com.alan.yx.springInAction.Chapter_05.Spittr.src.main.java.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 程序清单5.3HomeController：超级简单的控制器
 */
//声明为一个控制器
@Controller
// 处理对 "/" 的 GET 请求
@RequestMapping(value = {"/", "/homepage"})
public class HomeController {

    @RequestMapping(method = GET)
    public String home() {
        // 视图名为 home
        return "home";
    }

}
