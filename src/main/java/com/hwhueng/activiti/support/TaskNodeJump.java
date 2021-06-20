package com.hwhueng.activiti.support;


import cn.hutool.core.collection.CollectionUtil;
import io.vavr.collection.Seq;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.ActivitiException;
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
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 多实例并行节点跳转
 * */
public class TaskNodeJump implements Command<Void> {
    private static final Logger log = LoggerFactory.getLogger(TaskNodeJump.class);

    //@ApiModelProperty("流程实例Id")
    private final String processInstanceId;
    //@ApiModelProperty("目标节点")
    private final String targetNode;
    //@ApiModelProperty("变量")
    private final Map<String, Object> extraData;

    private final TaskService taskService;
    private final RepositoryService repositoryService;
    private ManagementService managementService;


    public TaskNodeJump(String processInstanceId,
                        String targetNode, Map<String, Object> extraData,
                        TaskService taskService,
                        RepositoryService repositoryService,
                        ManagementService managementService){
        this.processInstanceId = processInstanceId;
        this.targetNode = targetNode;
        this.extraData = extraData;
        this.taskService = taskService;
        this.repositoryService = repositoryService;
        this.managementService = managementService;

    }

    @Override
    public Void execute(CommandContext commandContext) {
        List<Task> taskList = taskService.createTaskQuery().processInstanceId(processInstanceId).list();
        if(CollectionUtil.isEmpty(taskList)){
            throw new ActivitiException("not execution task found");
        }
        org.activiti.bpmn.model.Process process = repositoryService.getBpmnModel(taskList.get(0).getProcessDefinitionId()).getMainProcess();
        //获取目标节点定义
        FlowNode targetNode = (FlowNode)process.getFlowElement(this.targetNode);
//        //删除当前运行任务
//        String executionEntityId = managementService.executeCommand(new DeleteTaskCmd(curTask.getId()));
//        //流程执行到来源节点
//        managementService.executeCommand(new SetFLowNodeAndGoCmd(targetNode, executionEntityId, this.extraData));

//        BpmnModel model = ProcessDefinitionUtil.getBpmnModel("Tt");
//        model.get
        ExecutionEntityManager executionEntityManager = Context
                .getCommandContext().getExecutionEntityManager();

        // ExecutionEntity executionEntity = executionEntityManager.findExecutionById(executionId);
        ExecutionEntity executionEntity = commandContext.getExecutionEntityManager().findById(taskList.get(0).getExecutionId());
//        //寻找根路径
//        String parentId = null;
//        while(executionEntity.getParent() != null){
//            parentId = executionEntity.getParentId();
//            executionEntity = executionEntity.getParent();
//
//        }
//        //设置相关变量
        executionEntity.setVariables(extraData);
//        executionEntity.setEventSource(this.currentActivity);
 //       executionEntity.setActivity(this.currentActivity);
//
        //删除无用的工作项
        TaskEntityManagerImpl taskEntityManager = (TaskEntityManagerImpl)commandContext.getTaskEntityManager();
        for (TaskEntity taskEntity : Context.getCommandContext()
                .getTaskEntityManager()
                .findTasksByExecutionId(processInstanceId)) {
            taskEntityManager.deleteTask(taskEntity, "jumpReason", false, false);
       }
//
//        //删除相关执行子路径，只保留根执行路径
        removeChildExecution(executionEntityManager, processInstanceId);
//
//
        try {
            commandContext.getIdentityLinkEntityManager()
                    .deleteIdentityLinksByTaskId(taskList.get(0).getId());
        }catch (Exception err){
            log.error("deleteIdentityLinksByProcInstance error: {}", ArrayUtils.toString(err.getStackTrace()));
        }
//        //要激活交路径
        executionEntity.setActive(true);
        jumpToTarget(targetNode, commandContext, executionEntity.getId());
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

    private void jumpToTarget(FlowNode flowElement, CommandContext context, String executionId){
        List<SequenceFlow> flows = flowElement.getIncomingFlows();
        if(flows==null || flows.size()<1){
            throw new ActivitiException("回退错误，目标节点没有来源连线");
        }
        for(SequenceFlow fl : flows) {
            FlowNode source = (FlowNode) fl.getSourceFlowElement();
            List<SequenceFlow> outSource = source.getOutgoingFlows();
            for(SequenceFlow fl2: outSource) {
                log.info("source: {}", fl2.getTargetRef());
                ExecutionEntity executionEntity = context.getExecutionEntityManager().findById(executionId);
                executionEntity.setCurrentFlowElement(fl2);
                executionEntity.setVariables(extraData);
                context.getAgenda().planTakeOutgoingSequenceFlowsOperation(executionEntity, true);
            }
        }
    }
}
