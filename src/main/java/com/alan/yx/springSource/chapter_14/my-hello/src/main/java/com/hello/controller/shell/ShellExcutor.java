package com.hello.controller.shell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Java 执行 shell 脚本工具类
 *
 * @author Alan Yin
 * @date 2020/4/9
 */

public class ShellExcutor {

    private static Logger log = LoggerFactory.getLogger("shell_logger");

    /**
     * Java执行shell脚本入口
     *
     * @param shellName 脚本文件名
     * @throws Exception
     */
    public void service(String shellName) throws Exception {
        String shellDir = "";
        String shellPath = "";
        try {
            //获取脚本所在的目录
//            String configFilePath = Thread.currentThread().getContextClassLoader().getResource("config.properties").getPath();
//            String configFilePath = "/Users/yinxing/desktop/pwd.sh";
            String configFilePath = "/Users/yinxing/desktop";

            File f = new File(configFilePath);
            shellDir = f.getParent();
            log.info("shell dir = " + shellDir);

            //拼接完整的脚本目录
            shellPath = shellDir + "/desktop/" + shellName;
            log.info("shell path = " + shellPath);

            //执行脚本
            log.info("shellPath is:{}", shellPath);
            callScript(shellPath);

        } catch (Exception e) {
            log.error("ShellExcutor异常" + e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 脚本文件具体执行及脚本执行过程探测
     *
     * @param script 脚本文件绝对路径
     * @throws Exception
     */
    private void callScript(String script) throws Exception {
        try {
            String cmd = "sh " + script;

            //启动独立线程等待process执行完成
            CommandWaitForThread commandThread = new CommandWaitForThread(cmd);
            commandThread.start();

            while (!commandThread.isFinish()) {
                log.info("shell " + script + " 还未执行完毕,10s后重新探测");
                Thread.sleep(10000);
            }

            //检查脚本执行结果状态码
            if (commandThread.getExitValue() != 0) {
                throw new Exception("shell " + script + "执行失败,exitValue = " + commandThread.getExitValue());
            }
            log.info("shell " + script + "执行成功,exitValue = " + commandThread.getExitValue());
        } catch (Exception e) {
            throw new Exception("执行脚本发生异常,脚本路径" + script, e);
        }
    }

    /**
     * 脚本函数执行线程
     */
    public class CommandWaitForThread extends Thread {

        private String cmd;
        private boolean finish = false;
        private int exitValue = -1;

        public CommandWaitForThread(String cmd) {
            this.cmd = cmd;
        }

        @Override
        public void run() {
            try {
                //执行脚本并等待脚本执行完成
                Process process = Runtime.getRuntime().exec(cmd);

                // 写出脚本执行中的过程信息
                BufferedReader infoInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                BufferedReader errorInput = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String line = "";
                while ((line = infoInput.readLine()) != null) {
                    log.info("line1 is:{}", line);
                }
                while ((line = errorInput.readLine()) != null) {
                    log.error("line2 is:{}", line);
                }
                infoInput.close();
                errorInput.close();

                //阻塞执行线程直至脚本执行完成后返回
                this.exitValue = process.waitFor();
            } catch (Throwable e) {
                log.error("CommandWaitForThread accure exception,shell " + cmd, e);
                exitValue = 110;
            } finally {
                finish = true;
            }
        }

        public boolean isFinish() {
            return finish;
        }

        public void setFinish(boolean finish) {
            this.finish = finish;
        }

        public int getExitValue() {
            return exitValue;
        }
    }

    public static void main(String[] args) {
//        ShellExcutor excutor = new ShellExcutor();
//        try {
//            excutor.service("pwd.sh");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        String s  = "p1.py";
        System.out.println(s.indexOf("/") != -1);

    }
}
