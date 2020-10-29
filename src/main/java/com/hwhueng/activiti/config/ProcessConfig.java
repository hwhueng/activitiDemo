package com.hwhueng.activiti.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ProcessConfig {
    @Autowired
    PlatformTransactionManager platformTransactionManager;

    @Autowired
    HikariDataSource hikariDataSource;

    @Autowired
    ProcessIdGenerate processIdGenerate;

    @Bean
    public ProcessEngineConfigurationImpl getProcessEngineConfiguration(ProcessEngineConfigurationImpl processEngineConfiguration){
        processEngineConfiguration.setIdGenerator(processIdGenerate);
        processEngineConfiguration.setActivityFontName("宋体");
        processEngineConfiguration.setLabelFontName("宋体");
        processEngineConfiguration.setAnnotationFontName("宋体");
        return processEngineConfiguration;
    }
}
