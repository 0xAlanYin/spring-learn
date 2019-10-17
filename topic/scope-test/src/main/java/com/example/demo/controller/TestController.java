package com.example.demo.controller;

import com.example.demo.bean.Watch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinxing
 * @date 2019/10/16
 */
@RestController
public class TestController {

    @Autowired
    private Watch watch;
    @Autowired
    private Watch game;

    @GetMapping(value = "/test1")
    public String test1() {
        watch.watchMovie();
        return "test";
    }

    @GetMapping(value = "/test2")
    public String test2() {
        game.watchMovie();
        return "test";
    }


}
