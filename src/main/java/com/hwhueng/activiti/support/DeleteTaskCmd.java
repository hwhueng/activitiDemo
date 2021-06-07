package com.hwhueng.activiti.support;

import org.activiti.engine.impl.cmd.NeedsActiveTaskCmd;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityManagerImpl;

public class DeleteTaskCmd extends NeedsActiveTaskCmd<String> {

    private static final long serialVersionUID = -5653001926618122383L;

    public DeleteTaskCmd(String taskId){
        super(taskId);
    }

    @Override
    protected String execute(CommandContext commandContext, TaskEntity task) {
        //获取所需服务
        TaskEntityManagerImpl taskEntityManager = (TaskEntityManagerImpl)commandContext.getTaskEntityManager();
        //获取当前任务的来源任务及来源节点信息
        ExecutionEntity executionEntity = task.getExecution();

        //寻找根路径
        String parentId = null;
        while(executionEntity.getParent() != null){
            parentId = executionEntity.getParentId();
            executionEntity = executionEntity.getParent();
        }

        //删除当前任务,来源任务
        taskEntityManager.deleteTask(task, "jumpReason", false, false);
        return executionEntity.getId();
    }


}
