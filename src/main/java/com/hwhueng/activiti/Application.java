package com.hwhueng.activiti;


import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@MapperScan("com.hwhueng.activiti.mapper")
@EnableMethodCache(basePackages = "com.hwhueng.activiti")
@EnableCreateCacheAnnotation
@SpringBootApplication(exclude = {org.activiti.spring.boot.SecurityAutoConfiguration.class,
org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableCaching
// @ImportAutoConfiguration(RedissonAutoConfiguration.class)
public class Application {
    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }
}
