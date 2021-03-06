package com.hwhueng.activiti.service.imp;

import cn.hutool.core.collection.CollectionUtil;
import com.hwhueng.activiti.exception.BusinessException;
import com.hwhueng.activiti.query.FlowTaskQuery;
import com.hwhueng.activiti.request.FlowRequest;
import com.hwhueng.activiti.request.TaskRequest;
import com.hwhueng.activiti.service.IFlowService;
import com.hwhueng.activiti.support.TaskNodeJump;
import com.hwhueng.activiti.vo.TodoTaskVo;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.TaskServiceImpl;
import org.activiti.engine.impl.interceptor.CommandExecutor;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.DelegationState;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FlowService implements IFlowService {
    @Resource
    RuntimeService runtimeService;

    @Resource
    TaskService taskService;

    @Resource
    RepositoryService repositoryService;
    @Resource
    ManagementService managementService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String startFlow(FlowRequest request) {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(request.getProcessDefinitionKey(), request.getExtra());
        return instance.getId();
    }

    @Override
    public List<TodoTaskVo> getTodoList(FlowTaskQuery query) {
//        if(StringUtils.isEmpty(query.getOwner()) && CollectionUtil.isEmpty(query.getAssigneeList()) && CollectionUtil.isEmpty(query.getProcessInstanceIdList())){
//            return Lists.newArrayList();
//        }

        TaskQuery qwr = taskService.createTaskQuery();
        if(CollectionUtil.isNotEmpty(query.getAssigneeList())){
            qwr.taskAssigneeIds(query.getAssigneeList());
        }

        if(StringUtils.isNotEmpty(query.getOwner())){
            qwr.taskOwner(query.getOwner());
        }

        if(CollectionUtil.isNotEmpty(query.getProcessInstanceIdList())){
            qwr.processInstanceIdIn(query.getProcessInstanceIdList());
        }

        List<Task> taskList = qwr.list();
        return taskList.stream().map(o->{
            TodoTaskVo vo = new TodoTaskVo();
            vo.setAssignee(o.getAssignee());
            vo.setProcessInstanceId(o.getProcessInstanceId());
            vo.setProcessDefKey(o.getProcessDefinitionId());
            vo.setStartTime(o.getCreateTime());
            vo.setTaskDefKey(o.getTaskDefinitionKey());
            vo.setEndTime(o.getClaimTime());
            vo.setTaskId(o.getId());
            vo.setProcDefId(o.getProcessDefinitionId());
            vo.setTaskName(o.getName());
            vo.setTaskDefKey(o.getTaskDefinitionKey());
            vo.setCreateTime(o.getCreateTime());
            vo.setOwner(o.getOwner());
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public void taskJump(TaskRequest request) {
        TaskNodeJump jump = new TaskNodeJump(request.getProcessInstanceId(), request.getTargetNode(), request.getExtra(), taskService, repositoryService, managementService);
        TaskServiceImpl taskServiceImpl=(TaskServiceImpl)taskService;
        CommandExecutor commandExecutor = taskServiceImpl.getCommandExecutor();
        commandExecutor.execute(jump);

    }

    @Override
    public void taskApprove(TaskRequest request) {
        String taskId = request.getTaskId();
        String assignee = request.getAssignee();
        Task task = taskService.createTaskQuery().taskId(taskId).includeProcessVariables().singleResult();
        if (assignee != null && !(task.getAssignee().equals(assignee) || assignee.equals(task.getOwner()))) {
            throw new BusinessException("task assignee not match");
        }
        DelegationState delegationState = task.getDelegationState();
        Map<String, Object> variables = request.getExtra();
        taskService.complete(taskId, variables, false);

    }
}
