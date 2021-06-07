package com.hwhueng.activiti.service;

import com.hwhueng.activiti.query.FlowTaskQuery;
import com.hwhueng.activiti.request.FlowRequest;
import com.hwhueng.activiti.vo.TodoTaskVo;

import java.util.List;

public interface IFlowService {

    String startFlow(FlowRequest request);
    List<TodoTaskVo> getTodoList(FlowTaskQuery query);
}
