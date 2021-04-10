package com.hwhueng.activiti.utils;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Component;

/**
 * 缓存工具类（j2cache）
 */
@Component
public class CacheUtils {
    private static CacheManager cacheManager;

    @Autowired
    public void setCacheManager(CacheManager cacheManager){
        CacheUtils.cacheManager = cacheManager;
    }

    public static Cache getCache(String region) {
        return cacheManager.getCache(region);
    }
    /**
     * 设置某缓存项种一个key对应的值
     *
     * @param region 例如:param
     * @param key    例如:projectName         当缓存是以spring注解@Cachable创建的时,一般key都是以冒号开头 例如periodOpenList缓存中的 :K3_anHui
     */
    public static void set(String region, String key, Object val) {
        if (null == val) {
            getCache(region).evict(key);
        } else {
            getCache(region).put(key, val);
        }
    }

    /**
     * 获取某缓存项种一个key对应的值
     *
     * @param region 例如:param
     * @param key    例如:projectName         当缓存是以spring注解@Cachable创建的时,一般key都是以冒号开头 例如periodOpenList缓存中的 :K3_anHui
     */
    public static <T> T get(String region, String key) {
        Cache.ValueWrapper valueWrapper = getCache(region).get(key);
        if (null == valueWrapper) {
            return null;
        }
        //noinspection unchecked
        return (T) valueWrapper;
    }

    /**
     * 清理一整个缓存项
     *
     * @param region 例如:param
     */
    public static void clear(String region) {
        getCache(region).clear();
    }

    /**
     * 清理缓存项中某几个key
     *
     * @param region 例如:param
     * @param keys    例如:projectName
     */
    public static void evict(String region, String...keys) {
        Cache cache = getCache(region);
        for (String key : keys) {
            cache.evict(key);
        }
    }
}