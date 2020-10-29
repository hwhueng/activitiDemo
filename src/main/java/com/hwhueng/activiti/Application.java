package com.hwhueng.activiti;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@SpringBootApplication(exclude = {org.activiti.spring.boot.SecurityAutoConfiguration.class,
org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class Application {
    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }
}
