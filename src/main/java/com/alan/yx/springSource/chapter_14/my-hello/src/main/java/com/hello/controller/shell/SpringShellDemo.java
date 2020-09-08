package com.hello.controller.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * Spring Shell 示例
 *
 * @author Alan Yin
 * @date 2020/4/9
 */
@ShellComponent
public class SpringShellDemo {

    @ShellMethod("add two number")
    public int add(int a, int b) {
        return a + b;
    }



}
