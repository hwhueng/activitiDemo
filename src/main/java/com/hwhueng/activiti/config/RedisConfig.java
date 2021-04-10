package com.hwhueng.activiti.config;

import org.redisson.api.RedissonClient;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

// @Configuration
public class RedisConfig {
    @Autowired
    RedissonClient redissonClient;

    @Bean
    public CacheManager cacheManager() {
        Map<String, CacheConfig> config = new HashMap<>();
        config.put("testCache", new CacheConfig(30*60*1000, 15*60*1000));
        return new RedissonSpringCacheManager(redissonClient, config);
    }
}
