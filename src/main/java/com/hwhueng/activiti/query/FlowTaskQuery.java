package com.hwhueng.activiti.query;

import java.io.Serializable;
import java.util.List;

public class FlowTaskQuery implements Serializable {
    private static final long serialVersionUID = -8882273621028562851L;

    private String owner;

    private List<String> assigneeList;

    private List<String> processInstanceIdList;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getAssigneeList() {
        return assigneeList;
    }

    public void setAssigneeList(List<String> assigneeList) {
        this.assigneeList = assigneeList;
    }

    public List<String> getProcessInstanceIdList() {
        return processInstanceIdList;
    }

    public void setProcessInstanceIdList(List<String> processInstanceIdList) {
        this.processInstanceIdList = processInstanceIdList;
    }
}
