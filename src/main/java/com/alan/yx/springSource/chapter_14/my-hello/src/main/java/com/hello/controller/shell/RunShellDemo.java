//package com.hello.controller;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
///**
// * @author Alan Yin
// * @date 2020/4/9
// */
//
//public class RunShellDemo {
//
//    public void runPicmodels() {
//        try {
//            String shpath = "/home/hzhao/project_bj";
//            String[] params = new String[] { "/bin/sh", "-c", "ls;pwd"};
//            Process ps=Runtime.getRuntime().exec(params);
//            ps.waitFor();
//
//            BufferedReader bufrIn = new BufferedReader(new InputStreamReader(ps.getInputStream(), "UTF-8"));
//            BufferedReader bufrError = new BufferedReader(new InputStreamReader(ps.getErrorStream(), "UTF-8"));
//
//            // 读取输出 result是shell中的输出
//            StringBuilder result = new StringBuilder();
//            String line = null;
//            while ((line = bufrIn.readLine()) != null || (line = bufrError.readLine()) != null) {
//                result.append(line).append('\n');
//            }
//
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args){
//        try {
//            String shpath="/home/hzhao/Project/note.sh";
//            Process ps = Runtime.getRuntime().exec(shpath);
//            ps.waitFor();
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
//            StringBuffer sb = new StringBuffer();
//            String line;
//            while ((line = brreadLine()) != null) {
//                sb.append(line).append("\n");
//            }
//            String result = sbtoString();
//            System.out.println(result);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
