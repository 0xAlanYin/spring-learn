package com.alan.yx.springInAction.Chapter_13.caching.src.main.java.spittr.config;

import com.alan.yx.springInAction.Chapter_12.redis.src.main.java.cart.Product;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.ArrayList;
import java.util.List;

@Configuration
// 启动缓存
@EnableCaching
public class CachingConfig {

    /**
     * 配置 EhCacheCacheManager
     * 声明缓存管理器
     *
     * @param cm
     * @return
     */
    @Bean
    public EhCacheCacheManager cacheManager(CacheManager cm) {
        return new EhCacheCacheManager(cm);
    }

    /**
     * 配置 EhCacheManagerFactoryBean
     *
     * @return
     */
    @Bean
    public EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean ehCacheFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheFactoryBean.setConfigLocation(new ClassPathResource("spittr/cache/ehcache.xml"));
        return ehCacheFactoryBean;
    }

//    //以下为 程序清单13.4 配置将缓存条目存储在Redis服务器的缓存管理器=================================================================
//    /**
//     * 配置将缓存条目存储在Redis服务器的缓存管理器
//     */
//    /**
//     * redis 缓存管理器
//     *
//     * @param redisTemplate
//     * @return
//     */
//    @Bean
//    public RedisCacheManager cacheManager(RedisTemplate redisTemplate) {
//        return new RedisCacheManager(redisTemplate);
//    }
//
//    /**
//     * redis 连接工厂
//     *
//     * @return
//     */
//    @Bean
//    public RedisConnectionFactory redisCF() {
//        return new JedisConnectionFactory();
//    }
//
//    /**
//     * RedisTemplate bean
//     *
//     * @param cf
//     * @return
//     */
//    @Bean
//    public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf) {
//        RedisTemplate<String, Product> redis = new RedisTemplate<String, Product>();
//        redis.setConnectionFactory(cf);
//        redis.setKeySerializer(new StringRedisSerializer());
//        redis.setValueSerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));
//        return redis;
//    }
//
//    //以下为 程序清单13.5 CompositeCacheManager会迭代一个缓存管理器的列表======================================================
//    @Bean
//    public CacheManager cacheManager(net.sf.ehcache.CacheManager cm, javax.cache.CacheManager jcm) {
//        // 创建 CompositeCacheManager
//        CompositeCacheManager cacheManager = new CompositeCacheManager();
//        List<CacheManager> managers = new ArrayList<>();
//        managers.add(new JCacheCacheManager(jcm));
//        managers.add(new EhCacheCacheManager(cm));
//        managers.add(new RedisCacheManager(redisTemplate()));
//        cacheManager.setCacheManagers(managers);
//        return cacheManager;
//    }


}
