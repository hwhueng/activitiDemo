package com.hwhueng.activiti.support;


import cn.hutool.core.collection.CollectionUtil;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityManager;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityManagerImpl;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

/**
 * 多实例并行节点跳转
 * */
public class TaskNodeJump implements Command<Void> {

    //@ApiModelProperty("流程实例Id")
    private String processInstanceId;
    //@ApiModelProperty("当前执行id")
    private String executionId;
    //@ApiModelProperty("当前节点")
    private FlowNode currentActivity;
    //@ApiModelProperty("目标节点")
    private String targetNode;
    //@ApiModelProperty("变量")
    private Map<String, Object> extraData;

    private TaskService taskService;
    private RepositoryService repositoryService;
    private ManagementService managementService;

    public TaskNodeJump(String processInstanceId, String executionId, FlowNode currentActivity,
                        String targetNode, Map<String, Object> extraData,
                        TaskService taskService,
                        RepositoryService repositoryService,
                        ManagementService managementService){
        this.processInstanceId = processInstanceId;
        this.executionId = executionId;
        this.currentActivity = currentActivity;
        this.targetNode = targetNode;
        this.extraData = extraData;
        this.taskService = taskService;
        this.repositoryService = repositoryService;
        this.managementService = managementService;

    }

    @Override
    public Void execute(CommandContext commandContext) {
        Task curTask = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
        org.activiti.bpmn.model.Process process = repositoryService.getBpmnModel(curTask.getProcessDefinitionId()).getMainProcess();
        //获取目标节点定义
        FlowNode targetNode = (FlowNode)process.getFlowElement(this.targetNode);
        //删除当前运行任务
        String executionEntityId = managementService.executeCommand(new DeleteTaskCmd(curTask.getId()));
        //流程执行到来源节点
        managementService.executeCommand(new SetFLowNodeAndGoCmd(targetNode, executionEntityId, this.extraData));

//        BpmnModel model = ProcessDefinitionUtil.getBpmnModel("Tt");
//        model.get
        ExecutionEntityManager executionEntityManager = Context
                .getCommandContext().getExecutionEntityManager();

        // ExecutionEntity executionEntity = executionEntityManager.findExecutionById(executionId);
        ExecutionEntity executionEntity = commandContext.getExecutionEntityManager().findById(curTask.getExecutionId());
//        //寻找根路径
        String parentId = null;
        while(executionEntity.getParent() != null){
            parentId = executionEntity.getParentId();
            executionEntity = executionEntity.getParent();

        }
//        //设置相关变量
        executionEntity.setVariables(extraData);
//        executionEntity.setEventSource(this.currentActivity);
 //       executionEntity.setActivity(this.currentActivity);
//
        //删除无用的工作项
        for (TaskEntity taskEntity : Context.getCommandContext()
                .getTaskEntityManager()
                .findTasksByExecutionId(processInstanceId)) {
            Context.getCommandContext().getTaskEntityManager()
                    .deleteTask(taskEntity.getId(), "jumped", true);
       }
//
//        //删除相关执行子路径，只保留根执行路径
        removeChildExecution(executionEntityManager, processInstanceId);
//
//
        try {
            commandContext.getIdentityLinkEntityManager()
                    .deleteIdentityLinksByTaskId(curTask.getId());
        }catch (Exception err){
            // log.error("deleteIdentityLinksByProcInstance error:" + err.getMessage());
        }
//        //要激活交路径
        executionEntity.setActive(true);
//
//        //触发事件监听器
//        this.execute(executionEntity);
//        InterpretableExecution propagatingExecution = null;
//        if (this.targetActivity.isScope()) {
//            propagatingExecution =  executionEntity.createExecution();
//            executionEntity.setTransition(null);
//            executionEntity.setActivity(null);
//            executionEntity.setActive(false);
//            propagatingExecution.initialize();
//
//        } else {
//            propagatingExecution = executionEntity;
//        }
//
//        propagatingExecution.executeActivity(this.targetActivity);

        return null;
    }

//    /**
//     * 删除子流程
//     * */
    private void removeChildExecution(ExecutionEntityManager executionEntityManager, String parentId){
        List<ExecutionEntity> list = executionEntityManager
                .findChildExecutionsByParentExecutionId(parentId);
        if(CollectionUtil.isEmpty(list)){
            return;
        }
        for(ExecutionEntity executionEntity: list){
            removeChildExecution(executionEntityManager, executionEntity.getId());
            executionEntityManager.deleteExecutionAndRelatedData(executionEntity, "jumpReason", false);
        }
    }
//
//    /**
//     * 触发事件监听器
//    */
//    public void execute(InterpretableExecution execution) {
//        ScopeImpl scope = getScope(execution);
//        List<ExecutionListener> executionListeners = scope.getExecutionListeners(getEventName());
//        for (ExecutionListener listener : executionListeners) {
//            execution.setEventName(getEventName());
//            execution.setEventSource(scope);
//            try {
//                listener.notify(execution);
//            } catch (RuntimeException e) {
//                throw e;
//            } catch (Exception e) {
//                throw new PvmException("couldn't execute event listener : " + e.getMessage(), e);
//            }
//
//        }
//    }


//    protected String getEventName() {
//        return org.activiti.engine.impl.pvm.PvmEvent.EVENTNAME_END;
//    }
//
//    protected ScopeImpl getScope(InterpretableExecution execution) {
//        return (ScopeImpl) execution.getActivity();
//    }
}
