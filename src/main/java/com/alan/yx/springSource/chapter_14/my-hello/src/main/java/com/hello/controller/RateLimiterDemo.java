package com.hello.controller;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * google guava 的限流器
 *
 * @author Alan Yin
 * @date 2020/3/26
 */

public class RateLimiterDemo {

    /**
     * 限流器流速: 2 个请求/秒
     */
    private RateLimiter rateLimiter = RateLimiter.create(2.0);

    /**
     * 执行任务的线程池
     */
    ExecutorService es = Executors.newFixedThreadPool(1);

    public void execRateLimit() {
        // 上一次执行时间
        final long[] prev = {System.currentTimeMillis()};
        for (int i = 0; i < 20; i++) {
            // 限流器限流
            rateLimiter.acquire();
            es.execute(() -> {
                long cur = System.currentTimeMillis();
                // 打印时间间隔:毫秒
                System.out.println(cur - prev[0]);
                prev[0] = cur;
            });
        }
    }

    public static void main(String[] args) {
        RateLimiterDemo demo = new RateLimiterDemo();
        demo.execRateLimit();
    }
}
