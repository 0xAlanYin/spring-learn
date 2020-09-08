package com.hello.controller.shell;

import java.io.File;
import java.io.IOException;

/**
 * @author Alan Yin
 * @date 2020/4/10
 */

public class ShellDemo2 {

    public static void main(String[] args) {

    }

    static void way1() throws IOException {
        String command = "ls";
        Process process = Runtime.getRuntime().exec(command);
    }

    static void way2() throws IOException, InterruptedException {
        String command1 = "ls";
        String command2 = "pwd";
        ProcessBuilder builder = new ProcessBuilder(command1, command2);

        // 如果遇到权限问题，可以使用ProcessBuilder对象先改变脚本执行权限后，再使用ProcessBuilder对象执行该脚本，例如：
        File tempFile = new File("/Users/yinxing/desktop/pwd.sh");
        ProcessBuilder builder2 = new ProcessBuilder("/bin/chmod", "755", tempFile.getPath());
        Process process = builder2.start();
        int rc = process.waitFor();
    }

    public void test() throws IOException {
        String[] cmdarray = new String[]{"ls","pwd"};
        String[] envp = new String[]{"dev","pro"};
        Process process = Runtime.getRuntime().exec(cmdarray,envp);
    }
}
