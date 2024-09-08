package redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.Collections;
import java.util.List;

public class RedisPipelinePerformanceTest {

    public static final String host = "127.0.0.1";
    public static final int port = 6379;
    public static final String password = "123456";

    public static void main(String[] args) {
        Jedis jedis = initialJedis();
        if (jedis == null) return;

        // testPipelinePerformance(jedis);

        // test pipeline response data processing
        testPipelineResponseDataProcessing(jedis);
    }


    // 响应数据（Response）的处理方式
    private static void testPipelineResponseDataProcessing(Jedis jedis) {
        String key = "keyStore";
        jedis.del(key);

        // method 1
        Pipeline p1 = jedis.pipelined();
        for (int i = 0; i < 5; i++) {
            p1.incr(key);
            System.out.println("p1 send request: " + i);
        }
        // receive response, and process response
        System.out.println("p1 receive response");
        List<Object> responses = p1.syncAndReturnAll();
        if (responses == null || responses.isEmpty()) {
            jedis.close();
            throw new RuntimeException("responses is empty");
        }
        for (Object response : responses) {
            System.out.println("p1 process response: " + response.toString());
        }
        System.out.println();


        // method 2
        jedis.del(key);
        Pipeline p2 = jedis.pipelined();
        //需要先声明Response
        Response<Long> r1 = p2.incr(key);
        System.out.println("p2 send request:1");
        Response<Long> r2 = p2.incr(key);
        System.out.println("p2 send request:2");
        Response<Long> r3 = p2.incr(key);
        System.out.println("p2 send request:3");
        Response<Long> r4 = p2.incr(key);
        System.out.println("p2 send request:4");
        Response<Long> r5 = p2.incr(key);
        System.out.println("p2 send request:5");

        try {
            r1.get();
        } catch (Exception e) {
            System.out.println("Pipeline error：还未开始接收响应 >>> ");
        }
        // send request finished, receive response
        System.out.println("send request finished, receive response");
        p2.sync();
        System.out.println("Pipeline接收响应Response:" + r1.get());
        System.out.println("Pipeline接收响应Response:" + r2.get());
        System.out.println("Pipeline接收响应Response:" + r3.get());
        System.out.println("Pipeline接收响应Response:" + r4.get());
        System.out.println("Pipeline接收响应Response:" + r5.get());
        jedis.close();
    }

    // 测试 Pipeline 的性能
    private static void testPipelinePerformance(Jedis jedis) {
        final int executeCount = 10000;
        String key = "keyStore";
        jedis.del(key);
        // not use pipeline
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < executeCount; i++) {
            // Send Request and  Receive Response
            jedis.incr(key);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("not use pipeline: " + (endTime - startTime) + " ms");

        // use pipeline
        jedis.del(key);
        startTime = System.currentTimeMillis();
        Pipeline pipelined = jedis.pipelined();
        for (int i = 0; i < executeCount; i++) {
            // send request
            pipelined.incr(key);
        }
        // receive response
        pipelined.sync();
        endTime = System.currentTimeMillis();
        System.out.println("use pipeline: " + (endTime - startTime) + " ms");


        // test result:
//        not use pipeline: 322 ms
//        use pipeline: 37 ms
    }

    private static Jedis initialJedis() {
        Jedis jedis = new Jedis(host, port);
        String auth = jedis.auth(password);
        if (!auth.equals("OK")) {
            System.out.println("Authentication failed");
            jedis.close();
            return null;
        }
        return jedis;
    }


}
