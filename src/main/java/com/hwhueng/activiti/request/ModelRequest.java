package com.hwhueng.activiti.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class ModelRequest implements Serializable {
    private static final long serialVersionUID = -8446633378847810741L;

    private String modelId;

    private String name;

    @JsonProperty(value = "jsonXml")
    private String jsonXml;

    @JsonProperty(value = "svgXml")
    private String svgXml;

    @JsonProperty(value = "description")
    private String description;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJsonXml() {
        return jsonXml;
    }

    public void setJsonXml(String jsonXml) {
        this.jsonXml = jsonXml;
    }

    public String getSvgXml() {
        return svgXml;
    }

    public void setSvgXml(String svgXml) {
        this.svgXml = svgXml;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
