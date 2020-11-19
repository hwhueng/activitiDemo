package com.hwhueng.activiti.support;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;

/**
 * 流程加签
 * */
public class AddSigner implements Command<Void> {

    private String executionId;
    private String assignee;

    public AddSigner(String executionId, String assignee){
        this.executionId = executionId;
        this.assignee = assignee;
    }

    @Override
    public Void execute(CommandContext commandContext) {
        return null;
    }
}
