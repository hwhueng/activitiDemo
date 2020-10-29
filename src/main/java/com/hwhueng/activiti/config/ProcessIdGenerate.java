package com.hwhueng.activiti.config;

import cn.hutool.core.util.IdUtil;
import org.activiti.engine.impl.cfg.IdGenerator;
import org.springframework.stereotype.Component;

@Component
public class ProcessIdGenerate implements IdGenerator{
    @Override
    public String getNextId() {
        return String.valueOf(IdUtil.getSnowflake(0,0).nextId());
    }
}