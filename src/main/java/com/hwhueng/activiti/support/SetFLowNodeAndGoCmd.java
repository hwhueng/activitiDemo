package com.hwhueng.activiti.support;

import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;

import java.util.List;
import java.util.Map;

//根据提供节点和执行对象id，进行跳转命令
public class SetFLowNodeAndGoCmd implements Command<Void> {
    private final FlowNode flowElement;
    private final String executionId;
    private final Map<String, Object> extra;

    public SetFLowNodeAndGoCmd(FlowNode flowElement, String executionId, Map<String, Object> extra){
        this.flowElement = flowElement;
        this.executionId = executionId;
        this.extra = extra;
    }

    public Void execute(CommandContext commandContext){
        //获取目标节点的来源连线
        List<SequenceFlow> flows = flowElement.getIncomingFlows();
        if(flows==null || flows.size()<1){
            throw new ActivitiException("回退错误，目标节点没有来源连线");
        }
        //随便选一条连线来执行，时当前执行计划为，从连线流转到目标节点，实现跳转
        ExecutionEntity executionEntity = commandContext.getExecutionEntityManager().findById(executionId);
        executionEntity.setCurrentFlowElement(flows.get(0));
        executionEntity.setVariables(extra);
        commandContext.getAgenda().planTakeOutgoingSequenceFlowsOperation(executionEntity, true);
        return null;
    }
}