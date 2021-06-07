package com.hwhueng.activiti.request;

import java.io.Serializable;
import java.util.Map;

public class FlowRequest implements Serializable {
    private static final long serialVersionUID = 7184589806042096207L;

    private String processDefinitionKey;

    private Map<String, Object> extra;

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }
}
