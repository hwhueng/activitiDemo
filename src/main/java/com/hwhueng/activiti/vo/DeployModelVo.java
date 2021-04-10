package com.hwhueng.activiti.vo;

import java.io.Serializable;

public class DeployModelVo implements Serializable {

    private static final long serialVersionUID = 4900602607700166686L;
    private String modelId;
    private String businessKey;
    private String category;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
