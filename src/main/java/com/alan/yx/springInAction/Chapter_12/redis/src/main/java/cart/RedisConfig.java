package com.alan.yx.springInAction.Chapter_12.redis.src.main.java.cart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    /**
     * 配置JedisConnectionFactory bean
     *
     * @return
     */
    @Bean
    public RedisConnectionFactory redisCF() {
//        JedisConnectionFactory jcf = new JedisConnectionFactory();
//        jcf.setHostName("redis-server");
//        jcf.setPort(7379);
//        jcf.setPassword("foobared");
//        return jcf;
        return new JedisConnectionFactory();
    }


    @Bean
    public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, Product> redis = new RedisTemplate<String, Product>();
        redis.setConnectionFactory(cf);
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));
        return redis;
    }


}
