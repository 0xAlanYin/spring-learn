package com.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alan Yin
 * @date 2020/12/4
 */
@RestController
public class GCMemoryOptimizeTest {

    private static AtomicInteger count = new AtomicInteger(0);

    // 试验1参数: -Xmx100m -Xms100m -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -Xloggc:your_path/heapTest.log
    // 试验2参数: -Xmx4g -Xms4g -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -Xloggc:your_path/heapTest.log
    // 试验3参数: -Xmx4g -Xms4g -Xmn3g -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -Xloggc:your_path/heapTest.log
    // 备注:此处因为小对象很多，试验3事先指定年轻代为 3g,可以进一步调优 JVM 内存（一般情况下没有特别准确的性能测试不建议启动）
    @RequestMapping(value = "/test1")
    public String test1(HttpServletRequest request) {
        List<Byte[]> temp = new ArrayList<Byte[]>();
        Byte[] b = new Byte[1024*1024];
        temp.add(b);
        System.out.println(count.incrementAndGet());
        return "success";
    }
}
