package com.hello.controller.shell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * @author Alan Yin
 * @date 2020/4/10
 */

public class ShellDemo1 {

    private static final Logger log = LoggerFactory.getLogger(ShellDemo1.class);

    private void callCMD(String tarName, String fileName, String... workspace) {
        try {
            String cmd = "tar -cf" + tarName + " " + fileName;
//            String[] cmd = {"tar", "-cf", tarName, fileName};
            File dir = null;
            if (workspace[0] != null) {
                dir = new File(workspace[0]);
                System.out.println(workspace[0]);
            }
            Process process = Runtime.getRuntime().exec(cmd, null, dir);
            int status = process.waitFor();
            if (status != 0) {
                System.err.println("Failed to call shell's command and the return status's is: " + status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void callScript(String script, String args, String... workspace) {
        try {
            String cmd = "sh " + script + " " + args;
//        	String[] cmd = {"sh", script, "4"};
            File dir = null;
            if (workspace[0] != null) {
                dir = new File(workspace[0]);
                System.out.println(workspace[0]);
            }
            String[] evnp = {"val=2", "call=Bash Shell"};
            Process process = Runtime.getRuntime().exec(cmd, evnp, dir);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                log.info("line is : {}", line);
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ShellDemo1 demo = new ShellDemo1();
        // demo.callCMD("/root/experiment/hive.tar", "/root/experiment/hive",null);
        demo.callScript("/Users/yinxing/desktop/test.sh", "4", "/Users/yinxing/desktop");
    }

}
