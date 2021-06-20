package com.hwhueng.activiti.controller;

import com.hwhueng.activiti.base.Resp;
import com.hwhueng.activiti.query.FlowTaskQuery;
import com.hwhueng.activiti.request.FlowRequest;
import com.hwhueng.activiti.request.TaskRequest;
import com.hwhueng.activiti.service.IFlowService;
import com.hwhueng.activiti.vo.TodoTaskVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/flow")
public class FlowController {
    @Resource
    IFlowService flowService;

    @PostMapping("/startFlow")
    public Resp<String> startFlow(@RequestBody FlowRequest request){
        String instanceId = flowService.startFlow(request);
        return new Resp<>(instanceId);
    }

    @PostMapping("/todoList")
    public Resp<List<TodoTaskVo>> getTodoList(@RequestBody FlowTaskQuery query){
        return new Resp<>(flowService.getTodoList(query));
    }

    @PostMapping("/taskJump")
    public Resp<String> taskJump(@RequestBody TaskRequest request){
        flowService.taskJump(request);
        return new Resp<>();
    }

    @PostMapping("/taskApprove")
    public Resp<String> taskApprove(@RequestBody TaskRequest request){
        flowService.taskApprove(request);
        return new Resp<>();
    }
}
